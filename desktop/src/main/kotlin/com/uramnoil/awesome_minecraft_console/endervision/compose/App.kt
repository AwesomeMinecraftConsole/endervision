package com.uramnoil.awesome_minecraft_console.endervision.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.uramnoil.awesome_minecraft_console.endervision.compose.molecules.ConsoleMonitor
import com.uramnoil.awesome_minecraft_console.endervision.compose.molecules.SideBar
import org.kodein.di.DI
import org.kodein.di.compose.withDI

fun app(
    vararg module: DI.Module,
) = application {
    withDI(*module) {
        Window(onCloseRequest = ::exitApplication, title = "EnderVision") {
            BoxWithConstraints(Modifier.fillMaxSize().background(Color(0xFF464D49))) {
                Row {
                    ConsoleMonitor()
                    SideBar()
                }
            }
        }
    }
}