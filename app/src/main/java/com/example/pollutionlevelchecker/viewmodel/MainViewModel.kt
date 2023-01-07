package com.example.pollutionlevelchecker.viewmodel

import android.location.Location
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pollutionlevelchecker.model.PollutionInfo
import com.example.pollutionlevelchecker.repository.MainRepository
import com.example.pollutionlevelchecker.util.CityNameConverter
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: MainRepository,
) : ViewModel() {

    private var userLatitude: Double = 0.0
    private var userLongitude: Double = 0.0

    fun getCurrentLocationName(latitude: Double, longitude: Double) {
        userLatitude = latitude
        userLongitude = longitude

        viewModelScope.launch {
            kotlin.runCatching {
                val userCoordinates = "$longitude,$latitude"
                val userLocation = repository.getUserLocation(userCoordinates)
                userLocation?.results?.get(0)?.region?.area1?.name.let { cityName ->
                    val sidoName = CityNameConverter.convert(cityName ?: "")
                    getCurrentPollutionInfo(sidoName)
                }
            }.onFailure { error ->
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

//                val stationCoordinates = mutableListOf<Pair<String, String>>()]
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
                    val nearestStation = stationList[nearestStationIndex]
                    Timber.e("+++++++++++++++++++++ Nearest Station Name : ${nearestStation.sidoName} ${nearestStation.stationName}")
                    Timber.e("+++++++++++++++++++++ Nearest Station PM10 Level : ${nearestStation.pm10Value}")
                } else {
                    Timber.e("+++++++++++++++++++++stationDistanceList is empty")
                }

            }.onFailure { error ->
                Timber.e("+++++++++++++++++++++${error.message}")
            }
        }
    }
}