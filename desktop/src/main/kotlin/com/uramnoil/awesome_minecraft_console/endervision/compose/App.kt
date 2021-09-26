package com.uramnoil.awesome_minecraft_console.endervision.compose

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.awaitApplication
import com.uramnoil.awesome_minecraft_console.endervision.compose.pages.ConnectionsPage

suspend fun app() = awaitApplication {
    Window(onCloseRequest = ::exitApplication, title = "EnderVision") {
        Box(Modifier.fillMaxSize()) {
            ConnectionsPage()
        }
    }
}