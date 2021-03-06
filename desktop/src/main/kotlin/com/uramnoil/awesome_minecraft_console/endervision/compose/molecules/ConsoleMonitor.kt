package com.uramnoil.awesome_minecraft_console.endervision.compose.molecules

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.uramnoil.awesome_minecraft_console.endervision.common.usecase.Line
import com.uramnoil.awesome_minecraft_console.endervision.compose.atoms.ArrowDownToggleButton
import com.uramnoil.awesome_minecraft_console.endervision.compose.atoms.Scrollbar

@Composable
fun ConsoleMonitor(lines: List<Line>) {
    var isTrackingBottom by remember { mutableStateOf(true) }

    BoxWithConstraints(
        Modifier.fillMaxSize().background(Color(0xFF272A2B)).padding(5.dp)
    ) {
        val lazyListState = rememberLazyListState()

        LaunchedEffect(lines.size) {
            if (isTrackingBottom) {
                val index = lines.size - 1
                lazyListState.scrollToItem(if (index < 0) 0 else index)
            }
        }

        Box(Modifier.fillMaxSize()) {
            Lines(lines, lazyListState)
        }

        Box(Modifier.align(Alignment.CenterEnd).fillMaxHeight()) {
            Scrollbar(lazyListState)
        }

        Box(Modifier.align(Alignment.BottomEnd)) {
            ArrowDownToggleButton(
                isTrackingBottom,
                onCheckedChange = {
                    isTrackingBottom = it
                },
                contentDescription = "Tracking bottom of console scroll position"
            )
        }
    }
}