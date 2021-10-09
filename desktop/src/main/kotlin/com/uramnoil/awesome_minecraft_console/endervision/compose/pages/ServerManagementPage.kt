package com.uramnoil.awesome_minecraft_console.endervision.compose.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
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
import com.uramnoil.awesome_minecraft_console.endervision.compose.organisms.ServerConnectionSideBar
import com.uramnoil.awesome_minecraft_console.endervision.compose.organisms.ServerFunctionSideBar
import com.uramnoil.awesome_minecraft_console.endervision.presentation.CommandController
import com.uramnoil.awesome_minecraft_console.endervision.presentation.OperationController
import com.uramnoil.awesome_minecraft_console.endervision.presentation.createServerPresentations
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.collect

@Composable
fun ServerManagementPage(server: Server) {
    val scope = rememberCoroutineScope()

    val (
        lineViewModel,
        notificationViewModel,
        onlinePlayersViewModel,
        enderVisionConnectionController,
        isConnectingViewModel,
        commandController,
        operationController
    ) = remember {
        createServerPresentations(
            server.host,
            server.port,
            Dispatchers.IO + Job()
        )
    }

    val isConnecting by isConnectingViewModel.isConnecting.collectAsState()

    Row(Modifier.fillMaxSize().background(Color(0xFF464D49))) {
        Box(Modifier.fillMaxHeight().weight(1f)) {
            if (isConnecting) {
                Connecting(
                    lineViewModel,
                    notificationViewModel,
                    onlinePlayersViewModel,
                    enderVisionConnectionController,
                    commandController,
                    operationController
                )
            } else {
                NotConnecting()
            }
        }
        Box(Modifier.fillMaxHeight().width(200.dp)) {
            ServerConnectionSideBar(
                isConnecting,
                connect = {
                    scope.launch {
                        enderVisionConnectionController.connect()
                    }
                },
                disconnect = {
                    scope.launch {
                        enderVisionConnectionController.disconnect()
                    }
                }
            )
        }
    }


}

@Composable
fun Connecting(
    lineViewModel: LineViewModel,
    notificationViewModel: NotificationViewModel,
    onlinePlayersViewModel: OnlinePlayersViewModel,
    enderVisionConnectionController: EnderVisionConnectionController,
    commandController: CommandController,
    operationController: OperationController,
) {
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

    Row(Modifier.fillMaxSize()) {
        Box(Modifier.fillMaxHeight().width(100.dp)) {
            ServerFunctionSideBar()
        }
        Box(Modifier.fillMaxHeight().weight(1f)) {
            Console(lines) {
                commandController.sendCommand(it)
            }
        }
    }
}

@Composable
fun NotConnecting() {
    Box(Modifier.fillMaxSize()) {
        Text("Please Connect to server.", Modifier.align(Alignment.Center))
    }
}