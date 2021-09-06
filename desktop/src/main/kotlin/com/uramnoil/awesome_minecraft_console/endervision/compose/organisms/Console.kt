package com.uramnoil.awesome_minecraft_console.endervision.compose.organisms

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.uramnoil.awesome_minecraft_console.endervision.compose.molecules.CommandController
import com.uramnoil.awesome_minecraft_console.endervision.compose.molecules.ConsoleMonitor
import com.uramnoil.awesome_minecraft_console.endervision.presentation.CommandController
import org.kodein.di.compose.LocalDI
import org.kodein.di.instance

@Composable
fun Console() {
    val controller by LocalDI.current.di.instance<CommandController>()

    BoxWithConstraints {
        Box {
            Box(Modifier.fillMaxHeight().padding(0.dp, 0.dp, 0.dp, 50.dp)) {
                ConsoleMonitor()
            }
            Box(Modifier.align(Alignment.BottomCenter).height(50.dp).fillMaxWidth()) {
                CommandController({
                    controller.sendCommand(it)
                })
            }
        }
    }
}