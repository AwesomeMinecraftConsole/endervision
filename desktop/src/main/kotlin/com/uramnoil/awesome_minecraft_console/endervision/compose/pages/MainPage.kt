package com.uramnoil.awesome_minecraft_console.endervision.compose.pages

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import com.uramnoil.awesome_minecraft_console.endervision.compose.organisms.ServerManager
import com.uramnoil.awesome_minecraft_console.endervision.presentation.createPresentationModule
import kotlinx.coroutines.launch
import org.kodein.di.DI

@Composable
fun MainPage() {
    val scope = rememberCoroutineScope()
    var host by remember { mutableStateOf("127.0.0.1") }
    var port by remember { mutableStateOf("50051") }
    var server by remember { mutableStateOf<Server?>(null) }

    if (server == null) {
        Column {
            TextField(host, onValueChange = { host = it })
            TextField(port, onValueChange = { value -> port = value.filter { it.isDigit() } })

            Button(onClick = {
                scope.launch {
                    kotlin.runCatching {
                        val module = createPresentationModule(
                            host,
                            port.toInt(),
                            scope
                        )
                        server = Server(module)
                    }.onFailure {
                        server = null
                    }
                }
            }) {
                Text("Connect")
            }
        }
    } else {
        ServerManager(server!!.serverModule) { server = null }
    }
}

data class Server(val serverModule: DI.Module)