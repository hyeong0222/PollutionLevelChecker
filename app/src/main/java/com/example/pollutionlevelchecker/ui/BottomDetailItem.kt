package com.example.pollutionlevelchecker.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pollutionlevelchecker.R
import com.example.pollutionlevelchecker.model.PollutionDetailInfo
import com.example.pollutionlevelchecker.model.PollutionInfo
import com.example.pollutionlevelchecker.ui.theme.MainTypography

@Composable
internal fun BottomDetailItem(pollutionDetailInfo: PollutionDetailInfo) {
    Column(
        modifier = Modifier.wrapContentSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(text = "${pollutionDetailInfo.title} >", style = MainTypography.bottomDetailText)

        Spacer(modifier = Modifier.height(10.dp))

        pollutionDetailInfo.icon.invoke()

        Spacer(modifier = Modifier.height(10.dp))

        Text(text = pollutionDetailInfo.levelText, style = MainTypography.bottomDetailText)

        Spacer(modifier = Modifier.height(10.dp))

        Text(text = pollutionDetailInfo.valueText, style = MainTypography.bottomDetailText)
    }
}

@Preview
@Composable
private fun BottomDetailItemPreview() {
    BottomDetailItem(
        pollutionDetailInfo = PollutionDetailInfo(title = "미세먼지", levelText = "보통", valueText = "47", icon = { Level4Icon() }),
    )
}

@Composable
internal fun Level1Icon() {
    Image(
        modifier = Modifier.size(20.dp),
        painter = painterResource(id = R.drawable.level1),
        colorFilter = ColorFilter.tint(color = Color.White),
        contentDescription = null
    )
}

@Composable
internal fun Level2Icon() {
    Image(
        modifier = Modifier.size(10.dp),
        painter = painterResource(id = R.drawable.level2),
        colorFilter = ColorFilter.tint(color = Color.White),
        contentDescription = null
    )
}

@Composable
internal fun Level3Icon() {
    Image(
        modifier = Modifier.size(10.dp),
        painter = painterResource(id = R.drawable.level3),
        colorFilter = ColorFilter.tint(color = Color.White),
        contentDescription = null
    )
}

@Composable
internal fun Level4Icon() {
    Image(
        modifier = Modifier.size(20.dp),
        painter = painterResource(id = R.drawable.level4),
        colorFilter = ColorFilter.tint(color = Color.White),
        contentDescription = null
    )
}

@Composable
internal fun Level5Icon() {
    Image(
        modifier = Modifier.size(20.dp),
        painter = painterResource(id = R.drawable.level5),
        colorFilter = ColorFilter.tint(color = Color.White),
        contentDescription = null
    )
}

@Composable
internal fun Level6Icon() {
    Image(
        modifier = Modifier.size(20.dp),
        painter = painterResource(id = R.drawable.level6),
        colorFilter = ColorFilter.tint(color = Color.White),
        contentDescription = null
    )
}

@Composable
internal fun Level7Icon() {
    Image(
        modifier = Modifier.size(20.dp),
        painter = painterResource(id = R.drawable.level7),
        colorFilter = ColorFilter.tint(color = Color.White),
        contentDescription = null
    )
}