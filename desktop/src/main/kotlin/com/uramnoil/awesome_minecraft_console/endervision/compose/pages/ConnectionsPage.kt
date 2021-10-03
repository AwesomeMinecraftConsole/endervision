package com.uramnoil.awesome_minecraft_console.endervision.compose.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.uramnoil.awesome_minecraft_console.endervision.common.presentation.LineViewModel
import com.uramnoil.awesome_minecraft_console.endervision.common.usecase.EnderVisionService
import com.uramnoil.awesome_minecraft_console.endervision.common.usecase.Line
import com.uramnoil.awesome_minecraft_console.endervision.compose.organisms.Console
import com.uramnoil.awesome_minecraft_console.endervision.compose.organisms.SideBar
import com.uramnoil.awesome_minecraft_console.endervision.presentation.CommandController
import com.uramnoil.awesome_minecraft_console.endervision.presentation.createPresentationModule
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.collect
import org.kodein.di.compose.LocalDI
import org.kodein.di.compose.withDI
import org.kodein.di.instance

@Composable
fun ConnectionsPage() {
    var server by remember { mutableStateOf<Server?>(null) }

    Box(Modifier.fillMaxSize()) {
        if (server != null) {
            ServerManager(server!!) { server = null }
        } else {
            EmptyConnections { server = it }
        }
    }
}

data class Server(val host: String, val port: UShort)

@Composable
fun ServerManager(server: Server, onExit: () -> Unit = {}) {
    val module = remember { createPresentationModule(server.host, server.port, Dispatchers.IO + Job()) }
    withDI(module) {
        val controller by LocalDI.current.di.instance<CommandController>()
        val lineViewModel by LocalDI.current.di.instance<LineViewModel>()
        val enderVisionService by LocalDI.current.di.instance<EnderVisionService>()

        val lines = remember { mutableStateListOf<Line>() }
        LaunchedEffect(Unit) {
            (this + CoroutineExceptionHandler { _, throwable ->
                println(throwable.message)
            }).launch {
                enderVisionService.connect()
                lineViewModel.lineFlow.collect {
                    lines.add(it)
                }
            }
        }
        Row(Modifier.fillMaxSize().background(Color(0xFF464D49))) {
            Box(Modifier.fillMaxHeight().weight(1f)) {
                Console(lines) {
                    controller.sendCommand(it)
                }
            }
            Box(Modifier.fillMaxHeight().width(200.dp)) {
                SideBar {
                    enderVisionService.disconnect()
                    onExit()
                }
            }
        }
    }
}

@Composable
fun EmptyConnections(onDidConnect: (Server) -> Unit) {
    val scope = rememberCoroutineScope()
    var host by remember { mutableStateOf("127.0.0.1") }
    var port by remember { mutableStateOf("50051") }
    var failed by remember { mutableStateOf<Throwable?>(null) }

    Box(Modifier.fillMaxSize()) {
        Column(modifier = Modifier.align(Alignment.Center)) {
            TextField(host, onValueChange = { host = it })
            TextField(port, onValueChange = { value -> port = value.filter { it.isDigit() } })

            Button(onClick = {
                scope.launch {
                    kotlin.runCatching {
                        onDidConnect(Server(host, port.toUShortOrNull() ?: 50051.toUShort()))
                    }.onFailure {
                        failed = it
                    }
                }
            }) {
                Text("Connect")
            }

            if (failed != null) {
                Text(failed!!.message!!)
            }
        }
    }
}