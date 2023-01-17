package com.example.pollutionlevelchecker.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pollutionlevelchecker.R

@Composable
internal fun TopBar(onNavigationIconClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(20.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Image(
            modifier = Modifier.clickable { onNavigationIconClick.invoke() },
            painter = painterResource(id = R.drawable.ic_baseline_menu),
            contentDescription = null,
            colorFilter = ColorFilter.tint(color = Color(0xFFFFFFFF))
        )

        Spacer(modifier = Modifier.weight(1f))

        Image(
            painter = painterResource(id = R.drawable.ic_baseline_map),
            contentDescription = null,
            colorFilter = ColorFilter.tint(color = Color(0xFFFFFFFF))
        )

        Spacer(modifier = Modifier.width(20.dp))

        Image(
            painter = painterResource(id = R.drawable.ic_baseline_share),
            contentDescription = null,
            colorFilter = ColorFilter.tint(color = Color(0xFFFFFFFF))
        )

        Spacer(modifier = Modifier.width(20.dp))

        Image(
//            modifier = Modifier.padding(end = 10.dp),
            painter = painterResource(id = R.drawable.ic_baseline_add),
            contentDescription = null,
            colorFilter = ColorFilter.tint(color = Color(0xFFFFFFFF))
        )



    }
}

@Preview(showBackground = true, backgroundColor = 0x000000)
@Composable
private fun TopBarPreview() {
    TopBar( onNavigationIconClick = { } )
}