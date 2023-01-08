package com.example.pollutionlevelchecker.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainScreen() {
    Scaffold(
        backgroundColor = Color.Black,
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopBar()
        }
    ) {
        MainContent()
    }
}