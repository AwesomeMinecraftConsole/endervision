package com.uramnoil.awesome_minecraft_console.endervision.compose.organisms

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun ServerConnectionSideBar(isConnection: Boolean, connect: () -> Unit, disconnect: () -> Unit) {
    Column(Modifier.fillMaxSize()) {
        if (!isConnection) {
            Button(onClick = connect) {
                Text("Connect")
            }
        } else {
            Button(onClick = disconnect) {
                Text("Disconnect")
            }
        }
    }
}

@Preview
@Composable
private fun Preview() {
    Box(Modifier.fillMaxSize()) {
        ServerConnectionSideBar(true, {}, {})
    }
}