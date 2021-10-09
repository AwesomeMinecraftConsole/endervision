package com.uramnoil.awesome_minecraft_console.endervision.compose.organisms

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ServerFunctionSideBar() {
    Column {
        FunctionItem("Console") {

        }
        FunctionItem("Players") {
        }
    }
}

@Composable
fun FunctionItem(text: String, color: Color = Color.White, onClick: () -> Unit = {}) {
    Box(Modifier.height(50.dp).fillMaxWidth().background(color).clickable(onClick = onClick)) {
        Box(Modifier.align(Alignment.Center)) {
            Text(text)
        }
    }
}