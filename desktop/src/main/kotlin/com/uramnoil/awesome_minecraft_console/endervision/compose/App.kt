package com.uramnoil.awesome_minecraft_console.endervision.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.awaitApplication
import com.uramnoil.awesome_minecraft_console.endervision.compose.molecules.SideBar
import com.uramnoil.awesome_minecraft_console.endervision.compose.organisms.Console
import org.kodein.di.DI
import org.kodein.di.compose.withDI
import kotlin.coroutines.CoroutineContext

suspend fun app(
    coroutineContext: CoroutineContext, vararg module: DI.Module,
) = awaitApplication {
    withDI(*module) {
        Window(onCloseRequest = ::exitApplication, title = "EnderVision") {
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