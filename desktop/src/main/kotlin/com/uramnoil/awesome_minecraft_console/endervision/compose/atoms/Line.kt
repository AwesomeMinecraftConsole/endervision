package com.uramnoil.awesome_minecraft_console.endervision.compose.atoms

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.uramnoil.ansies.parse.removeAnsi
import com.uramnoil.awesome_minecraft_console.endervision.common.usecase.Line

@Composable
fun Line(line: Line) {
    Text(line.value.removeAnsi(), color = Color.White, modifier = Modifier.fillMaxWidth())
}

@Preview
@Composable
fun PreviewLine() {
    Line(Line("Hoge"))
}