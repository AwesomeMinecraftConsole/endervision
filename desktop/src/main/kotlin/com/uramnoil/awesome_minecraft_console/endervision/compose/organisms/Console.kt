package com.uramnoil.awesome_minecraft_console.endervision.compose.organisms

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.uramnoil.awesome_minecraft_console.endervision.common.presentation.LineViewModel
import com.uramnoil.awesome_minecraft_console.endervision.common.usecase.Line
import com.uramnoil.awesome_minecraft_console.endervision.compose.molecules.CommandController
import com.uramnoil.awesome_minecraft_console.endervision.compose.molecules.ConsoleMonitor
import com.uramnoil.awesome_minecraft_console.endervision.presentation.CommandController
import kotlinx.coroutines.flow.collect
import org.kodein.di.compose.LocalDI
import org.kodein.di.instance

@Composable
fun Console() {
    val controller by LocalDI.current.di.instance<CommandController>()
    val viewModel by LocalDI.current.di.instance<LineViewModel>()
    val lines = remember { mutableStateListOf<Line>() }

    LaunchedEffect(Unit) {
        viewModel.lineFlow.collect {
            lines.add(it)
        }
    }

    BoxWithConstraints {
        Column {
            Box(Modifier.weight(1f).fillMaxWidth()) {
                ConsoleMonitor(lines)
            }
            Box(Modifier.height(50.dp).fillMaxWidth()) {
                CommandController {
                    controller.sendCommand(it)
                }
            }
        }
    }
}