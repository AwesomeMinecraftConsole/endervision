package com.uramnoil.awesome_minecraft_console.endervision.compose.molecules

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.key.Key
import androidx.compose.ui.input.key.key
import androidx.compose.ui.input.key.onKeyEvent
import com.uramnoil.awesome_minecraft_console.endervision.compose.atoms.CommandInput
import com.uramnoil.awesome_minecraft_console.endervision.compose.atoms.SubmitButton

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
            Box(Modifier.weight(90f)) {
                CommandInput(command, onValueChange = { command = it })
            }
            Box(Modifier.weight(10f)) {
                SubmitButton { submitIfInputIsNotBlank() }
            }
        }
    }
}