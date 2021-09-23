package com.uramnoil.awesome_minecraft_console.endervision.compose.organisms

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import org.kodein.di.DI
import org.kodein.di.compose.withDI

@Composable
fun ServerManager(serverModule: DI.Module, onExit: () -> Unit = {}) {
    withDI(serverModule) {
        Row(Modifier.fillMaxSize().background(Color(0xFF464D49))) {
            Box(Modifier.fillMaxHeight().weight(1f)) {
                Console()
            }
            Box(Modifier.fillMaxHeight().width(200.dp)) {
                SideBar(onExit)
            }
        }
    }
}