package com.example.pollutionlevelchecker.repository

import com.example.pollutionlevelchecker.model.MainResponse
import com.example.pollutionlevelchecker.network.ApiService
import com.example.pollutionlevelchecker.network.NaverMapsApiService
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MainRepository @Inject constructor(
    private val apiService: ApiService,
    private val naverMapsApiService: NaverMapsApiService,
) {
    suspend fun getCurrentPollutionInfo(sidoName: String): MainResponse? = apiService.getCurrentPollutionInfo(sidoName = sidoName)

    suspend fun getUserLocation(coordinates: String) = naverMapsApiService.getUserLocation(coordinates = coordinates)

    suspend fun getCityCoordinates(address: String) = naverMapsApiService.getCityCoordinates(address = address)
}