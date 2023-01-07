package com.example.pollutionlevelchecker.util

object CityNameConverter {

    fun convert(cityName: String): String {
        return when (cityName) {
            "서울특별시" -> "서울"
            "부산광역시" -> "부산"
            "대구광역시" -> "대구"
            "인천광역시" -> "인천"
            "광주광역시" -> "광주"
            "대전광역시" -> "대전"
            "경기도" -> "경기"
            "강원도" -> "강원"
            "충청북도" -> "충북"
            "충청남도" -> "충남"
            "전라북도" -> "전북"
            "전라남도" -> "전남"
            "경상북도" -> "경북"
            "경상남도" -> "경남"
            "제주특별자치도" -> "제주"
            "세종특별자치시" -> "세종"
            else -> "전국"
        }
    }
}