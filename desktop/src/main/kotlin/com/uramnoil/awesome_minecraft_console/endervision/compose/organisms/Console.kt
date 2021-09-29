package com.uramnoil.awesome_minecraft_console.endervision.compose.organisms

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.uramnoil.awesome_minecraft_console.endervision.common.usecase.Line
import com.uramnoil.awesome_minecraft_console.endervision.compose.molecules.CommandController
import com.uramnoil.awesome_minecraft_console.endervision.compose.molecules.ConsoleMonitor

@Composable
fun Console(lines: List<Line>, onSubmitCommand: (String) -> Unit = {}) {
    BoxWithConstraints {
        Column {
            Box(Modifier.weight(1f).fillMaxWidth()) {
                ConsoleMonitor(lines)
            }
            Box(Modifier.height(50.dp).fillMaxWidth()) {
                CommandController(onSubmitCommand)
            }
        }
    }
}