package com.uramnoil.awesome_minecraft_console.endervision.compose

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.awaitApplication
import com.uramnoil.awesome_minecraft_console.endervision.compose.pages.MainPage

suspend fun app() = awaitApplication {
    Window(onCloseRequest = ::exitApplication, title = "EnderVision - ") {
        MainPage()
    }
}