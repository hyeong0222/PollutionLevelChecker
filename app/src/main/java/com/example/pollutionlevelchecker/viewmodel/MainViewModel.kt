package com.example.pollutionlevelchecker.viewmodel

import android.location.Location
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pollutionlevelchecker.model.PollutionInfo
import com.example.pollutionlevelchecker.repository.MainRepository
import com.example.pollutionlevelchecker.ui.MainViewState
import com.example.pollutionlevelchecker.util.CityNameConverter
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: MainRepository,
) : ViewModel() {

    private val _currentStationInfo = MutableStateFlow(MainViewState())
    val currentStationInfo = _currentStationInfo.asStateFlow()

    private var userLatitude: Double = 0.0
    private var userLongitude: Double = 0.0

    init {
        setLoading()
    }

    fun setCurrentLocation(latitude: Double, longitude: Double) {
        userLatitude = latitude
        userLongitude = longitude
        requestData()
    }

    fun requestData(isRefresh: Boolean = false) {
        viewModelScope.launch {
            if (isRefresh) setRefreshing()

            kotlin.runCatching {
                val userCoordinates = "$userLongitude,$userLatitude"
                val userLocation = repository.getUserLocation(userCoordinates)
                userLocation?.results?.get(0)?.region?.area1?.name.let { cityName ->
                    val sidoName = CityNameConverter.convert(cityName ?: "")
                    getCurrentPollutionInfo(sidoName)
                }
            }.onFailure { error ->
                setError(error)
                Timber.e("++++++++++++++++++${error.message}")
            }
        }
    }

    private fun getCurrentPollutionInfo(sidoName: String) {
        viewModelScope.launch {
            kotlin.runCatching {
                val pollutionInfo = repository.getCurrentPollutionInfo(sidoName)

                val stationList = mutableListOf<PollutionInfo>()
                pollutionInfo?.response?.body?.pollutionInfoList?.let { list ->
                    list.forEach { station -> stationList.add(station) }
                }

                val stationDistanceList = mutableListOf<Pair<Int, Float>>()
                stationList.forEachIndexed { index, station ->
                    val searchText = "$sidoName ${station.stationName}"
                    val stationCityCoordinates = repository.getCityCoordinates(searchText)

                    if (stationCityCoordinates?.addresses?.isNotEmpty() == true) {
                        val a = stationCityCoordinates.addresses[0]
//                        val distance = Location.distanceBetween(userLatitude, userLongitude, a.y.toDouble(), a.x.toDouble())
                        val userLocation = Location("userLocation").apply {
                            latitude = userLatitude
                            longitude = userLongitude
                        }
                        val stationLocation = Location("stationLocation").apply {
                            latitude = a.y.toDouble()
                            longitude = a.x.toDouble()
                        }

                        val distance = userLocation.distanceTo(stationLocation)
                        stationDistanceList.add(Pair(index, distance))
                    }
                }

                if (stationDistanceList.isNotEmpty()) {
                    val nearestStationIndex = stationDistanceList.minBy { (_, distance) -> distance }.first
                    _currentStationInfo.update { state ->
                        state.copy(pollutionInfo = stationList[nearestStationIndex])
                    }
                    showData()
//                    val nearestStation = stationList[nearestStationIndex]
//                    Timber.e("+++++++++++++++++++++ Nearest Station Name : ${nearestStation.sidoName} ${nearestStation.stationName}")
//                    Timber.e("+++++++++++++++++++++ Nearest Station PM10 Level : ${nearestStation.pm10Value}")
                } else {
                    Timber.e("+++++++++++++++++++++stationDistanceList is empty")
                }

            }.onFailure { error ->
                setError(error)
                Timber.e("+++++++++++++++++++++${error.message}")
            }
        }
    }

    private fun setLoading() {
        _currentStationInfo.update { state ->
            state.copy(loading = true)
        }
    }

    private fun showData() {
        _currentStationInfo.update { state ->
            state.copy(loading = false, refreshing = false, error = null)
        }
    }

    private fun setError(error: Throwable) {
        _currentStationInfo.update { state ->
            state.copy(error = error, loading = false)
        }
    }

    private fun setRefreshing() {
        _currentStationInfo.update { state ->
            state.copy(refreshing = true)
        }
    }
}