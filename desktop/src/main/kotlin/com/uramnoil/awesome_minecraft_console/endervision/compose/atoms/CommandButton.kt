package com.uramnoil.awesome_minecraft_console.endervision.compose.atoms

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SendButton(onClick: () -> Unit) {
    Button(onClick, Modifier.fillMaxSize()) {
        Icon(Icons.Filled.Send, "Dispatch command")
    }
}


@Preview
@Composable
fun SendButtonPreview() {
    Box(Modifier.height(50.dp).width(50.dp)) {
        Button({}, Modifier.fillMaxSize()) {
            Icon(Icons.Filled.Send, "Dispatch command")
        }
    }
}