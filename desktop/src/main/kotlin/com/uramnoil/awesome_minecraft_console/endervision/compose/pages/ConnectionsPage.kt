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
import com.uramnoil.awesome_minecraft_console.endervision.common.presentation.NotificationViewModel
import com.uramnoil.awesome_minecraft_console.endervision.common.presentation.OnlinePlayersViewModel
import com.uramnoil.awesome_minecraft_console.endervision.common.usecase.EnderVisionConnectionController
import com.uramnoil.awesome_minecraft_console.endervision.common.usecase.Line
import com.uramnoil.awesome_minecraft_console.endervision.compose.organisms.Console
import com.uramnoil.awesome_minecraft_console.endervision.compose.organisms.LeftSideBar
import com.uramnoil.awesome_minecraft_console.endervision.compose.organisms.SideBar
import com.uramnoil.awesome_minecraft_console.endervision.presentation.CommandController
import com.uramnoil.awesome_minecraft_console.endervision.presentation.OperationController
import com.uramnoil.awesome_minecraft_console.endervision.presentation.createServerPresentations
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.collect

@Composable
fun ConnectionsPage() {
    var server by remember { mutableStateOf<Server?>(null) }

    Box(Modifier.fillMaxSize()) {
        if (server != null) {
            val (
                lineViewModel,
                notificationViewModel,
                onlinePlayersViewModel,
                enderVisionConnectionController,
                commandController,
                operationController
            ) = remember {
                createServerPresentations(
                    server!!.host,
                    server!!.port,
                    Dispatchers.IO + Job()
                )
            }

            ServerManager(
                lineViewModel,
                notificationViewModel,
                onlinePlayersViewModel,
                enderVisionConnectionController,
                commandController,
                operationController
            ) { server = null }
        } else {
            EmptyConnections { server = it }
        }
    }
}

data class Server(val host: String, val port: UShort)

@Composable
fun ServerManager(
    lineViewModel: LineViewModel,
    notificationViewModel: NotificationViewModel,
    onlinePlayersViewModel: OnlinePlayersViewModel,
    enderVisionConnectionController: EnderVisionConnectionController,
    commandController: CommandController,
    operationController: OperationController,
    onExit: () -> Unit = {}
) {
    val scope = rememberCoroutineScope()

    val lines = remember { mutableStateListOf<Line>() }
    LaunchedEffect(Unit) {
        (this + CoroutineExceptionHandler { _, throwable ->
            println(throwable.message)
        }).launch {
            enderVisionConnectionController.connect()
            lineViewModel.flow.collect {
                lines.add(it)
            }
        }
    }

    Row(Modifier.fillMaxSize().background(Color(0xFF464D49))) {
        Box(Modifier.fillMaxHeight().weight(0.5f)) {
            LeftSideBar()
        }
        Box(Modifier.fillMaxHeight().weight(1f)) {
            Console(lines) {
                commandController.sendCommand(it)
            }
        }
        Box(Modifier.fillMaxHeight().width(200.dp)) {
            SideBar {
                scope.launch {
                    enderVisionConnectionController.disconnect()
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