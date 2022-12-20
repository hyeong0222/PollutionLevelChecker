package com.example.pollutionlevelchecker.network

import com.example.pollutionlevelchecker.model.MapsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface NaverMapsApiService {

    @GET("/map-reversegeocode/v2/gc")
    suspend fun getUserLocation(
        @Query("coords") coordinates: String,
        @Query("output") output: String = "json",
    ): MapsResponse?
}