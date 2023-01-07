package com.example.pollutionlevelchecker.model

import com.google.gson.annotations.SerializedName

data class MapsReverseGeocodeResponse(
//    @SerializedName("geocoding")
//    val geocoding: Geocoding

//    @SerializedName("results")
//    val results: List<Result>
    val name: String,
    val results: List<Result>
)

//data class Geocoding(
//    @SerializedName("results")
//    val results: List<Results>
//)

data class Result(
//    @SerializedName("orders")
//    val orders: List<Order>
    @SerializedName("name")
    val name: String,
    @SerializedName("region")
    val region: Region
)

//data class Order(
//    val region: Region
//)

data class Region(
    val area0: Area,
    val area1: Area,
    val area2: Area,
    val area3: Area,
    val area4: Area
)

data class Area(
    val name: String? = "",
    val alias: String? = "",
)