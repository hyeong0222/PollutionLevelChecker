package com.example.pollutionlevelchecker.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pollutionlevelchecker.R
import com.example.pollutionlevelchecker.model.PollutionDetailInfo
import com.example.pollutionlevelchecker.ui.theme.MainTypography

@Composable
internal fun BottomDetailContent() {
    Column(
        modifier = Modifier
            .padding(horizontal = 5.dp)
            .fillMaxWidth()
            .wrapContentHeight()
            .background(shape = RoundedCornerShape(5.dp), color = Color(0xFF5B5E5E))
            .padding(vertical = 10.dp, horizontal = 10.dp)
    ){
        Text(
            text = "상세 정보",
            style = MainTypography.bottomDetailText
        )

        Spacer(modifier = Modifier.height(10.dp))

        Divider(
            color = Color.Gray,
            thickness = 0.5.dp,
            modifier = Modifier.padding(horizontal = 5.dp)
        )

        Spacer(modifier = Modifier.height(10.dp))

        val list = listOf(
            PollutionDetailInfo(title = "미세먼지", levelText = "보통", valueText = "47", icon = { Level4Icon() }),
            PollutionDetailInfo(title = "초미세먼지", levelText = "좋음", valueText = "15", icon = { Level6Icon() }),
            PollutionDetailInfo(title = "이산화질소", levelText = "양호", valueText = "0.039", icon = { Level5Icon() }),
            PollutionDetailInfo(title = "오존", levelText = "최고 좋음", valueText = "0.003", icon = { Level7Icon() }),
            PollutionDetailInfo(title = "일산화탄소", levelText = "최고 좋음", valueText = "0.4", icon = { Level7Icon() }),
            PollutionDetailInfo(title = "아황산가스", levelText = "최고 좋음", valueText = "0.002", icon = { Level7Icon() })
        )
        Row(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                modifier = Modifier
                    .size(20.dp),
                painter = painterResource(id = R.drawable.ic_arrow_left),
                contentDescription = null,
            )

            LazyRow(
                modifier = Modifier.weight(1f),
                horizontalArrangement = Arrangement.spacedBy(40.dp),
            ) {
                items(list) { item ->
                    BottomDetailItem(pollutionDetailInfo = item)
                }
            }

            Image(
                modifier = Modifier
                    .size(20.dp),
                painter = painterResource(id = R.drawable.ic_arrow_right),
                contentDescription = null,
            )

        }
    }
}

@Preview
@Composable
private fun BottomDetailContentPreview() {
    BottomDetailContent()
}