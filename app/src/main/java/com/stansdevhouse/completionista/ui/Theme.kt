package com.stansdevhouse.completionista.ui

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorPalette = darkColors(
    primary = carbonBlue500,
    primaryVariant = carbonBlue500,
    onPrimary = Color.White,
    secondary = peach500,
    background = carbonBlue500,
    onSecondary = Color.Black,
    error = peach700,
    surface = carbonBlue700
)

private val LightColorPalette = lightColors(
    primary = carbonBlue500,
    primaryVariant = carbonBlue700,
    onPrimary = Color.White,
    secondary = peach500,
    background = Color.White,
    onSecondary = Color.Black,
    error = peach700,
    surface = carbonBlue700
)

@Composable
fun CompletionistaTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable() () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = typography,
        shapes = shapes,
        content = content
    )
}