package com.uramnoil.awesome_minecraft_console.endervision.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.awaitApplication
import com.uramnoil.awesome_minecraft_console.endervision.compose.molecules.SideBar
import com.uramnoil.awesome_minecraft_console.endervision.compose.organisms.Console
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
            BoxWithConstraints(Modifier.fillMaxSize().background(Color(0xFF464D49))) {
                Box(Modifier.fillMaxHeight().fillMaxWidth(0.7f)) {
                    Console()
                }
                Box(Modifier.fillMaxHeight().fillMaxWidth(0.3f)) {
                    SideBar()
                }
            }
        }
    }
}