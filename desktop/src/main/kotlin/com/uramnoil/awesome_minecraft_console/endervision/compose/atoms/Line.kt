package com.uramnoil.awesome_minecraft_console.endervision.compose.atoms

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.uramnoil.minecraft_awesome_console.endervision.common.models.usecase.Line

@Composable
fun Line(line: Line) {
    Text(line.line, color = Color.White, modifier = Modifier.fillMaxWidth())
}

@Preview
@Composable
fun PreviewLine() {
    Line(Line("Hoge"))
}