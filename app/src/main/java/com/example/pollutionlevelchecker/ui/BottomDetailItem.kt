package com.example.pollutionlevelchecker.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.pollutionlevelchecker.model.PollutionInfo

@Composable
internal fun BottomDetailItem(pollutionInfo: PollutionInfo) {
    Column(modifier = Modifier.wrapContentSize()) {
        Text(text = "미세먼지")
    }
}