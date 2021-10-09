package com.uramnoil.awesome_minecraft_console.endervision.compose.atoms

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import com.uramnoil.ansies.parameter.*
import com.uramnoil.ansies.parse.ansi
import com.uramnoil.ansies.toSpans
import com.uramnoil.awesome_minecraft_console.endervision.common.usecase.Line

@Composable
fun Line(line: Line) {
    Box(Modifier.fillMaxWidth()) {
        Text(buildAnnotatedString {
            line.value.ansi().asciiCodeOrStringList.toSpans().forEach {
                val style = SpanStyle(
                    when (it.sgr.foregroundColor) {
                        BlackForeground -> Color.Black
                        BlueForeground -> Color.Blue
                        CyanForeground -> Color.Cyan
                        DefaultForegroundColor -> Color.White
                        GreenForeground -> Color.Green
                        MagentaForeground -> Color.Magenta
                        RedForeground -> Color.Red
                        is SelectForegroundColor -> Color.White
                        WhiteForeground -> Color.White
                        YellowForeground -> Color.Yellow
                        null -> Color.White
                    }
                )
                withStyle(style) {
                    append(it.string)
                }
            }
        }, modifier = Modifier.fillMaxWidth())
    }
}

@Preview
@Composable
fun PreviewLine() {
    Box(Modifier.background(Color.Black)) {
        Line(Line("Hoge"))
    }
}