package com.example.pollutionlevelchecker.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pollutionlevelchecker.R
import com.example.pollutionlevelchecker.ui.theme.MainTypography

@Composable
internal fun MainContent(mainViewState: MainViewState) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(top = 40.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = stringResource(id = R.string.current_location_text),
            style = MainTypography.currentLocationText
        )

        Text(
            text = "${mainViewState.pollutionInfo.sidoName} ${mainViewState.pollutionInfo.stationName}",
            style = MainTypography.userCurrentLocationText
        )

        Text(
            text = mainViewState.pollutionInfo.dataTime,
            style = MainTypography.lastUpdatedText
        )

        Spacer(modifier = Modifier.height(40.dp))

        Image(
            modifier = Modifier.size(150.dp),
            painter = painterResource(id = R.drawable.gas_mask),
            contentDescription = null,
            colorFilter = ColorFilter.tint(color = Color(0xFFFFFFFF)),
        )

        Spacer(modifier = Modifier.height(40.dp))

        Text(
            text = "최악",
            style = MainTypography.pollutionLevelText,
        )

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = "절대 나가지 마세요!!!",
            style = MainTypography.warningMessageText,
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0x000000)
@Composable
private fun MainContentPreview() {
    MainContent(mainViewState = MainViewState())
}