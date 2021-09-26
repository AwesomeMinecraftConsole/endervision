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
import com.uramnoil.awesome_minecraft_console.endervision.compose.organisms.ServerManager
import com.uramnoil.awesome_minecraft_console.endervision.presentation.createPresentationModule
import kotlinx.coroutines.launch
import org.kodein.di.DI

@Composable
fun ConnectionsPage() {
    var server by remember { mutableStateOf<Server?>(null) }

    Box(Modifier.fillMaxSize()) {
        if (server != null) {
            ServerManager(server!!.serverModule) { server = null }
        } else {
            EmptyConnections { server = it }
        }
    }
}

data class Server(val serverModule: DI.Module)

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
                        val module = createPresentationModule(
                            host,
                            port.toInt(),
                            this
                        )
                        onDidConnect(Server(module))
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