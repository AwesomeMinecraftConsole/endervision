package com.uramnoil.awesome_minecraft_console.endervision.compose.organisms

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun SideBar(onExit: () -> Unit) {
    Box(Modifier.fillMaxSize()) {
        Button(onClick = onExit) {
            Text("Exit")
        }
    }
}