package com.uramnoil.awesome_minecraft_console.endervision.compose.pages

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun ConnectionsPage() {
    val servers = remember { mutableStateListOf<Server>() }

    Box(Modifier.fillMaxSize()) {
        if (servers.isEmpty()) {
            EmptyConnections { servers.add(it) }
        } else {
            servers.forEach {
                ServerManagementPage(it)
            }
        }
    }
}

data class Server(val host: String, val port: UShort)

@Composable
fun EmptyConnections(onDidConnect: (Server) -> Unit) {
    var host by remember { mutableStateOf("127.0.0.1") }
    var port by remember { mutableStateOf("50051") }

    Box(Modifier.fillMaxSize()) {
        Column(modifier = Modifier.align(Alignment.Center)) {
            TextField(host, onValueChange = { host = it })
            TextField(port, onValueChange = { value -> port = value.filter { it.isDigit() } })

            Text("There are no servers. Please input the server's host and port that you want to connect.")
            Button(onClick = { onDidConnect(Server(host, port.toUShortOrNull() ?: 50051.toUShort())) }) {
                Text("Connect")
            }
        }
    }
}