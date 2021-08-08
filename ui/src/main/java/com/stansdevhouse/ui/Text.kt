package com.stansdevhouse.ui

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.ExperimentalUnitApi

@ExperimentalUnitApi
@ExperimentalMaterialApi
@Composable
fun SmallCarouselTitle(title: String, modifier: Modifier = Modifier) {
    BaseText(
        text = title,
        modifier = modifier,
        fontWeight = FontWeight.ExtraBold,
        style = MaterialTheme.typography.h5,
        textAlign = TextAlign.Center
    )
}

@ExperimentalMaterialApi
@Composable
fun ToolbarTitle(title: String, modifier: Modifier = Modifier) {
    BaseText(
        text = title,
        modifier = modifier,
        fontWeight = FontWeight.Bold,
        style = MaterialTheme.typography.h4,
        textAlign = TextAlign.Start
    )
}

@ExperimentalMaterialApi
@Composable
fun BaseText(
    text: String,
    modifier: Modifier,
    fontWeight: FontWeight,
    style: TextStyle,
    textAlign: TextAlign
) {
    Text(
        text = text,
        modifier = modifier,
        color = MaterialTheme.colors.secondary,
        fontWeight = fontWeight,
        style = style,
        textAlign = textAlign
    )
}

@ExperimentalUnitApi
@ExperimentalMaterialApi
@Preview
@Composable
fun CardTitlePreview() {
    SmallCarouselTitle(title = "Grand Theft Auto 5")
}

@ExperimentalUnitApi
@ExperimentalMaterialApi
@Preview
@Composable
fun ToolbarTitlePreview() {
    ToolbarTitle(title = "Collection")
}