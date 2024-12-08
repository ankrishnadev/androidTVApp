package com.krishna.androidtvapp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.tv.material3.Button
import androidx.tv.material3.Icon
import androidx.tv.material3.NavigationDrawer
import androidx.tv.material3.NavigationDrawerItem
import androidx.tv.material3.Text

@Composable
fun NavigationDrawerUI() {
    var selectedIndex by remember { mutableIntStateOf(0) }
    val listItems = listOf(
        "Home" to Icons.Default.Home,
        "Movies" to Icons.Default.PlayArrow,
        "Series" to Icons.Default.List,
        "News" to Icons.Default.Info,
        "Hot & Stories" to Icons.Default.ThumbUp
    )

    NavigationDrawer(
        drawerContent = {
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .padding()
                    .background(
                        brush = Brush.horizontalGradient(
                            listOf(
                                Color.DarkGray,
                                Color.Transparent
                            )
                        )
                    )
                    .selectableGroup(),
                verticalArrangement = Arrangement.Center
            ) {
                listItems.forEachIndexed { index, item ->
                    val (text, icon) = item
                    NavigationDrawerItem(
                        modifier = Modifier.padding(horizontal = 12.dp),
                        selected = selectedIndex == index,
                        onClick = { selectedIndex = index },
                        leadingContent = {
                            Icon(imageVector = icon, contentDescription = text)
                        }
                    ) {
                        Text(
                            text = text,
                            modifier = Modifier.fillMaxWidth(),
                            color = if (selectedIndex == index) {
                                Color.White
                            } else Color.White
                        )
                    }
                }
            }
        },
        modifier = Modifier,
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.DarkGray)
                .padding(start = 30.dp, end = 20.dp, top = 20.dp, bottom = 20.dp)
        ) {
            Button(modifier = Modifier
                .fillMaxWidth()
                .padding(start = 30.dp, end = 20.dp, top = 20.dp, bottom = 20.dp), onClick = {

            }) { Text("BUTTON") }
        }

    }
}