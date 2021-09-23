package com.uramnoil.awesome_minecraft_console.endervision.compose

import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.awaitApplication
import com.uramnoil.awesome_minecraft_console.endervision.compose.pages.ServerPage
import com.uramnoil.awesome_minecraft_console.endervision.presentation.createPresentationModule
import org.kodein.di.compose.withDI

suspend fun app() = awaitApplication {
    Window(onCloseRequest = ::exitApplication, title = "EnderVision") {
        val coroutineScope = rememberCoroutineScope()
        val module = remember {
            createPresentationModule(
                System.getenv("ENDERVISION_SERVER_HOST"),
                System.getenv("ENDERVISION_SERVER_PORT").toInt(),
                coroutineScope
            )
        }

        withDI(module) {
            ServerPage()
        }
    }
}