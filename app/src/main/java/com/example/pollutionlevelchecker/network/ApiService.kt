package com.example.pollutionlevelchecker.network

import com.example.pollutionlevelchecker.BuildConfig
import com.example.pollutionlevelchecker.model.MainResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("/B552584/ArpltnInforInqireSvc/getCtprvnRltmMesureDnsty")
    suspend fun getCurrentPollutionInfo(
        @Query("dataTerm") dataTerm: String = "day",
        @Query("returnType") returnType: String = "json",
        @Query("sidoName") sidoName: String,
        @Query("serviceKey") serviceKey: String = BuildConfig.API_KEY,
    ): MainResponse?
}