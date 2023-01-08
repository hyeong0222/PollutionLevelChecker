package com.example.pollutionlevelchecker.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pollutionlevelchecker.R
import com.example.pollutionlevelchecker.ui.theme.MainTypography

@Composable
internal fun MainContent() {
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
            text = "구리시 인창동",
            style = MainTypography.userCurrentLocationText
        )

        Text(
            text = "2023-01-07 09:45 PM",
            style = MainTypography.lastUpdatedText
        )

        Spacer(modifier = Modifier.height(20.dp))
        
        Image(painter = painterResource(id = R.drawable.gas_mask), contentDescription = null)
    }
}

@Preview(showBackground = true, backgroundColor = 0x000000)
@Composable
private fun MainContentPreview() {
    MainContent()
}