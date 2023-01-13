package com.example.pollutionlevelchecker.ui.theme

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.dp
import com.example.pollutionlevelchecker.extension.toSp

class TypographyVariants(
    private val density: Density,
    val currentLocationText: TextStyle = TextStyle(
        fontFamily = FontFamily.SansSerif,
        fontWeight = FontWeight.W600,
        fontSize = 18.dp.toSp(density),
        color = Color.White,
    ),

    val userCurrentLocationText: TextStyle = TextStyle(
        fontFamily = FontFamily.SansSerif,
        fontWeight = FontWeight.W800,
        fontSize = 24.dp.toSp(density),
        color = Color.White,
    ),

    val lastUpdatedText: TextStyle = TextStyle(
        fontFamily = FontFamily.SansSerif,
        fontWeight = FontWeight.W400,
        fontSize = 20.dp.toSp(density),
        color = Color.Gray,
    ),

    val pollutionLevelText: TextStyle = TextStyle(
        fontFamily = FontFamily.SansSerif,
        fontWeight = FontWeight.W400,
        fontSize = 26.dp.toSp(density),
        color = Color.White,
    ),

    val warningMessageText: TextStyle = TextStyle(
        fontFamily = FontFamily.SansSerif,
        fontWeight = FontWeight.W400,
        fontSize = 18.dp.toSp(density),
        color = Color.White,
    ),

    val bottomDetailText: TextStyle = TextStyle(
        fontFamily = FontFamily.SansSerif,
        fontWeight = FontWeight.W500,
        fontSize = 8.dp.toSp(density),
        color = Color.White,
    ),
)