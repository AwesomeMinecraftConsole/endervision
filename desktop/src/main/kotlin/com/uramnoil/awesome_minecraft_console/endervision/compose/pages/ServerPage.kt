package com.uramnoil.awesome_minecraft_console.endervision.compose.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.uramnoil.awesome_minecraft_console.endervision.compose.molecules.SideBar
import com.uramnoil.awesome_minecraft_console.endervision.compose.organisms.Console

@Composable
fun ServerPage() {
    BoxWithConstraints(Modifier.fillMaxSize().background(Color(0xFF464D49))) {
        Box(Modifier.fillMaxSize().padding(0.dp, 0.dp, 200.dp, 0.dp)) {
            Console()
        }
        Box(Modifier.fillMaxSize().padding(200.dp, 0.dp, 0.dp, 0.dp)) {
            SideBar()
        }
    }
}