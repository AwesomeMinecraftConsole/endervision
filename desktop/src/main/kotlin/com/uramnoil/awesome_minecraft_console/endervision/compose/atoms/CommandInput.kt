package com.uramnoil.awesome_minecraft_console.endervision.compose.atoms

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp

@Composable
fun CommandInput(
    value: String,
    onValueChange: (String) -> Unit,
) {
    Box {
        TextField(
            value = value,
            onValueChange = onValueChange,
            modifier = Modifier.fillMaxWidth(),
            maxLines = 1,
            textStyle = TextStyle(color = Color.White),
        )
    }
}


@Preview
@Composable
fun CommandInputPreview() {
    Box(Modifier.border(1.dp, Color.Black)) {
        CommandInput("input", {})
    }
}
