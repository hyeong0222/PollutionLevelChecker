package com.example.pollutionlevelchecker.model

data class MapsGeocodeResponse(
    val addresses: List<Address>
)

data class Address(
    val x: String = "",
    val y: String = "",
)
