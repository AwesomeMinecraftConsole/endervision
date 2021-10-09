package com.uramnoil.awesome_minecraft_console.endervision.compose.molecules

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.key.Key
import androidx.compose.ui.input.key.key
import androidx.compose.ui.input.key.onKeyEvent
import androidx.compose.ui.unit.dp
import com.uramnoil.awesome_minecraft_console.endervision.compose.atoms.CommandInput
import com.uramnoil.awesome_minecraft_console.endervision.compose.atoms.SendButton

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun CommandController(onSubmitCommand: (String) -> Unit = {}) {
    var command by remember { mutableStateOf("") }

    val submitIfInputIsNotBlank = {
        if (command.isNotBlank()) {
            onSubmitCommand(command)
            command = ""
        }
    }

    BoxWithConstraints(Modifier.fillMaxSize()
        .onKeyEvent {
            if (it.key.keyCode == Key.Enter.keyCode) {
                submitIfInputIsNotBlank()
                false
            } else {
                true
            }
        }
    ) {
        Row {
            Box(Modifier.weight(1f)) {
                CommandInput(command, onValueChange = { command = it })
            }
            Box(Modifier.width(50.dp).fillMaxHeight()) {
                SendButton { submitIfInputIsNotBlank() }
            }
        }
    }
}

@Preview
@Composable
fun CommandController() {
    Box(Modifier.fillMaxWidth().height(50.dp)) {
        CommandController()
    }
}