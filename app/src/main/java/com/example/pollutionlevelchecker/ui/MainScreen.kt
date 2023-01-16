package com.example.pollutionlevelchecker.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.pollutionlevelchecker.viewmodel.MainViewModel

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainScreen(viewModel: MainViewModel = hiltViewModel()) {
    val mainViewState = viewModel.currentStationInfo.collectAsStateWithLifecycle().value

    Scaffold(
        backgroundColor = Color.Black,
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopBar()
        }
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            if (mainViewState.loading) {
                CircularProgressIndicator(modifier = Modifier.size(50.dp))
            } else {
                MainContent(mainViewState)

                Spacer(modifier = Modifier.height(50.dp))

                BottomDetailContent()
            }
        }
    }
}