package com.example.pollutionlevelchecker.model

import com.google.gson.annotations.SerializedName

data class MainResponse(
    val response: Response
)

data class Response(
    val body: Body
)

data class Body(
    val totalCount: Int,
    @SerializedName("items")
    val pollutionInfoList: List<PollutionInfo> = listOf()
)
