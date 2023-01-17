package com.example.pollutionlevelchecker.model

import androidx.compose.runtime.Composable

data class PollutionDetailInfo(
    val title: String = "",
    val levelText: String = "",
    val valueText: String = "",
    val icon: @Composable () -> Unit,
)
