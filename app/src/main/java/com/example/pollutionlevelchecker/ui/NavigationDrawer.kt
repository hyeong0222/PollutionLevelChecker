package com.example.pollutionlevelchecker.ui

import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pollutionlevelchecker.R
import com.example.pollutionlevelchecker.ui.theme.MainTypography

@Composable
internal fun DrawerHeader() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .background(color = Color(0xFF05F6D5)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Spacer(modifier = Modifier.height(20.dp))

        Image(painter = painterResource(id = R.drawable.cloud), contentDescription = null, modifier = Modifier.size(50.dp), colorFilter = ColorFilter.tint(color = Color.White))

        Spacer(modifier = Modifier.height(10.dp))

        Text(text = "미세미세", style = MainTypography.drawerHeaderTitle)

        Spacer(modifier = Modifier.height(5.dp))

        Text(text = "Ver 6.8.3", style = MainTypography.drawerHeaderVersion)

        Spacer(modifier = Modifier.height(20.dp))
    }
}

@Composable
internal fun DrawerBody() {
    Column(modifier = Modifier.padding(vertical = 20.dp, horizontal = 20.dp)) {
        Text(text = "아끼는 사람에게 알려주기", style = MainTypography.drawerContentText)

        Spacer(modifier = Modifier.height(20.dp))

        Text(text = "미세먼지 세계보건기구(WHO) 기준", style = MainTypography.drawerContentText)

        Spacer(modifier = Modifier.height(20.dp))

        Text(text = "미세먼지 8단계 모드", style = MainTypography.drawerContentText)

        Spacer(modifier = Modifier.height(20.dp))

        Text(text = "불편/개선 사항 보내기", style = MainTypography.drawerContentText)

        Spacer(modifier = Modifier.height(20.dp))

        Text(text = "미세먼지 정보", style = MainTypography.drawerContentText)

        Spacer(modifier = Modifier.height(20.dp))

        Text(text = "예보 이미지", style = MainTypography.drawerContentText)

        Spacer(modifier = Modifier.height(20.dp))

        Text(text = "미세먼지 알람/경보", style = MainTypography.drawerContentText)

        Spacer(modifier = Modifier.height(20.dp))

        Text(text = "광고 제거", style = MainTypography.drawerContentText)

        Spacer(modifier = Modifier.height(20.dp))

        Text(text = "설정 (위치 삭제, 위젯)", style = MainTypography.drawerContentText)

        Spacer(modifier = Modifier.height(20.dp))

        Text(text = "'날씨날씨'앱 다운받기", style = MainTypography.drawerContentText)
    }
}