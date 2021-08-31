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
import com.uramnoil.awesome_minecraft_console.endervision.compose.viewmodel.ServerNameViewModel
import com.uramnoil.minecraft_awesome_console.endervision.common.models.usecase.Line
import com.uramnoil.minecraft_awesome_console.endervision.common.models.usecase.LineViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import org.kodein.di.DI

fun app(
    di: DI,
    serverNameViewModel: ServerNameViewModel = ServerNameViewModel("")
) = application {
    val lineFlow = MutableSharedFlow<Line>(0)
    val lineViewModel = LineViewModel(lineFlow)

    Window(onCloseRequest = ::exitApplication, title = "EnderVision") {
        BoxWithConstraints(Modifier.fillMaxSize().background(Color(0xFF464D49))) {
            Row {
                ConsoleMonitor(lineViewModel)
                SideBar {
                    lineFlow.emit(Line(it))
                }
            }
        }
    }
}