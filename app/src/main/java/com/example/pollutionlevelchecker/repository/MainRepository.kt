package com.example.pollutionlevelchecker.repository

import com.example.pollutionlevelchecker.model.MainResponse
import com.example.pollutionlevelchecker.network.ApiService
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MainRepository @Inject constructor(
    private val apiService: ApiService
) {
    suspend fun getCurrentPollutionInfo(): MainResponse? = apiService.getCurrentPollutionInfo()
}