package com.stansdevhouse.ui

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.text.HtmlCompat
import com.google.android.material.textview.MaterialTextView

@ExperimentalUnitApi
@Composable
fun SmallCarouselTitle(title: String, modifier: Modifier = Modifier) {
    BaseText(
        text = title,
        modifier = modifier,
        color = MaterialTheme.colors.secondary,
        fontWeight = FontWeight.ExtraBold,
        style = MaterialTheme.typography.h5,
        textAlign = TextAlign.Center
    )
}

@Composable
fun HtmlTextView(text: String, modifier: Modifier = Modifier) {
    AndroidView(
        modifier = modifier,
        factory = { context ->
            MaterialTextView(context).apply {

            }
        },
        update = { view ->
            view.text = HtmlCompat.fromHtml(text, HtmlCompat.FROM_HTML_MODE_COMPACT)
        }
    )
}

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

@Composable
fun BaseText(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colors.onSurface,
    fontWeight: FontWeight = FontWeight.Normal,
    style: TextStyle = TextStyle.Default,
    textAlign: TextAlign = TextAlign.Start
) {
    Text(
        text = text,
        modifier = modifier,
        color = color,
        fontWeight = fontWeight,
        style = style,
        textAlign = textAlign
    )
}

@ExperimentalUnitApi
@Preview
@Composable
fun CardTitlePreview() {
    SmallCarouselTitle(title = "Grand Theft Auto 5")
}

@ExperimentalUnitApi
@Preview
@Composable
fun ToolbarTitlePreview() {
    ToolbarTitle(title = "Collection")
}