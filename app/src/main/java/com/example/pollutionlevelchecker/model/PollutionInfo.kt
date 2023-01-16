package com.example.pollutionlevelchecker.model

data class PollutionInfo(
    val stationName: String = "",
    val sidoName: String = "",
    val dataTime: String = "",

    // 미세먼지
    val pm10Value: String = "",

    // 초미세먼지
    val pm25Value: Int = 0,

    // 이산화탄소
    val no2Value: Float = 0.0f,

    // 오존
    val o3Value: Float = 0.0f,

    // 일산화탄소
    val coValue: Float = 0.0f,

    // 아황산가스
    val so2Value: Float = 0.0f,
)

//enum class PollutionType {
//    PM10,
//    PM25,
//    NO2,
//    O3,
//    CO,
//    SO2,
//}
//
//fun PollutionInfo.getPollutionTitle(): String {
//
//}