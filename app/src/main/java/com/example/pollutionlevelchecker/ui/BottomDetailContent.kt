package com.example.pollutionlevelchecker.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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

        Row() {

        }
    }
}

@Preview
@Composable
private fun BottomDetailContentPreview() {
    BottomDetailContent()
}