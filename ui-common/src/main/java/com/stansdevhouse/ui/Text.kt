package com.stansdevhouse.ui

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.text.HtmlCompat
import com.google.android.material.textview.MaterialTextView

@Composable
fun SmallCarouselTitle(title: String, modifier: Modifier = Modifier) {
    BaseText(
        text = title,
        modifier = modifier,
        color = MaterialTheme.colorScheme.onSurface,
        fontWeight = FontWeight.ExtraBold,
        style = MaterialTheme.typography.headlineMedium,
        textAlign = TextAlign.Center
    )
}

@Composable
fun HtmlTextView(text: String, modifier: Modifier = Modifier) {
    AndroidView(
        modifier = modifier,
        factory = { context ->
            MaterialTextView(context)
        },
        update = { view ->
            view.text = HtmlCompat.fromHtml(text, HtmlCompat.FROM_HTML_MODE_COMPACT)
        }
    )
}

@Composable
fun ToolbarTitle(title: String, modifier: Modifier = Modifier) {
    Text(
        text = title,
        modifier = modifier
    )
}

@Composable
fun BaseText(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colorScheme.onSurface,
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

@Preview
@Composable
fun CardTitlePreview() {
    SmallCarouselTitle(title = "Grand Theft Auto 5")
}

@Preview
@Composable
fun ToolbarTitlePreview() {
    ToolbarTitle(title = "Collection")
}