package com.example.pollutionlevelchecker.network

import com.example.pollutionlevelchecker.model.MapsGeocodeResponse
import com.example.pollutionlevelchecker.model.MapsReverseGeocodeResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface NaverMapsApiService {

    @GET("/map-reversegeocode/v2/gc")
    suspend fun getUserLocation(
        @Query("coords") coordinates: String,
        @Query("output") output: String = "json",
    ): MapsReverseGeocodeResponse?

    @GET("/map-geocode/v2/geocode")
    suspend fun getCityCoordinates(
        @Query("query") address: String,
    ): MapsGeocodeResponse?
}