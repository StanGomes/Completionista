package com.stansdevhouse.ui

import android.util.Log
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.SmallTopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun Toolbar(title: String, iconClick: () -> Unit) {
    SmallTopAppBar(
        title = {
            ToolbarTitle(title = title)
        },
        actions = {
            IconButton(onClick = { iconClick() }) {
                Icon(
                    Icons.Rounded.Search,
                    contentDescription = "Search",
                    modifier = Modifier.size(32.dp)
                )
            }
        }
    )
}

@Composable
@Preview
fun ToolbarPreview() {
    Toolbar(title = "Collection", iconClick = { Log.d("Collection Screen", "icon clicked") })
}