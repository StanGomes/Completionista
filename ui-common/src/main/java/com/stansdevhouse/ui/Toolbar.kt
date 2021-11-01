package com.stansdevhouse.ui

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun Toolbar(title: String, iconClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        ToolbarTitle(title = title)
        IconButton(onClick = { iconClick() }) {
            Icon(
                Icons.Rounded.Search,
                contentDescription = "Search",
                tint = MaterialTheme.colors.onSurface,
                modifier = Modifier.size(32.dp)
            )
        }
    }
}

@Composable
@Preview
fun ToolbarPreview() {
    Toolbar(title = "Collection", iconClick = { Log.d("Collection Screen", "icon clicked") })
}