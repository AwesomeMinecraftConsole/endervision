package com.uramnoil.awesome_minecraft_console.endervision.compose.molecules

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.uramnoil.awesome_minecraft_console.endervision.compose.atoms.ArrowDownToggleButton
import com.uramnoil.awesome_minecraft_console.endervision.compose.atoms.Lines
import com.uramnoil.awesome_minecraft_console.endervision.compose.atoms.Scrollbar
import com.uramnoil.minecraft_awesome_console.endervision.common.models.usecase.Line
import com.uramnoil.minecraft_awesome_console.endervision.common.models.usecase.LineViewModel
import kotlinx.coroutines.flow.collect
import org.kodein.di.compose.LocalDI
import org.kodein.di.instance

@Composable
fun ConsoleMonitor() {
    val coroutineScope = rememberCoroutineScope()
    val lines = remember { mutableStateListOf<Line>() }
    val viewModel by LocalDI.current.di.instance<LineViewModel>()
    var isTrackingBottom by remember { mutableStateOf(true) }

    BoxWithConstraints(
        Modifier.fillMaxSize().background(Color(0xFF272A2B)).padding(5.dp)
    ) {
        val lazyListState = rememberLazyListState()

        LaunchedEffect(Unit) {
            viewModel.lineFlow.collect {
                lines.add(it)
                if (isTrackingBottom) {
                    lazyListState.animateScrollToItem(lines.size)
                    println("hoge")
                }
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