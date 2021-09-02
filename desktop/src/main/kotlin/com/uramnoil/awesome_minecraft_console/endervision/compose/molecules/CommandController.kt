package com.uramnoil.awesome_minecraft_console.endervision.compose.molecules

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.uramnoil.awesome_minecraft_console.endervision.compose.atoms.CommandInput
import com.uramnoil.awesome_minecraft_console.endervision.compose.atoms.SubmitButton

@Composable
fun CommandController(onSubmitCommand: (String) -> Unit = {}) {
    var command by remember { mutableStateOf("") }

    BoxWithConstraints(Modifier.fillMaxSize()) {
        Row {
            Box(Modifier.weight(90f)) {
                CommandInput(command, onValueChange = { command = it })
            }
            Box(Modifier.weight(10f)) {
                SubmitButton {
                    onSubmitCommand(command)
                    command = ""
                }
            }
        }
    }
}