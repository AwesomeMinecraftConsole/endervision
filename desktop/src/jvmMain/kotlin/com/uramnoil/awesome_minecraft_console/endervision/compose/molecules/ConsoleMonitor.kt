package com.uramnoil.awesome_minecraft_console.endervision.compose.molecules

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.uramnoil.awesome_minecraft_console.endervision.compose.atoms.Lines
import com.uramnoil.awesome_minecraft_console.endervision.compose.atoms.Scrollbar
import com.uramnoil.minecraft_awesome_console.endervision.common.models.usecase.Line
import com.uramnoil.minecraft_awesome_console.endervision.common.models.usecase.LineViewModel
import kotlinx.coroutines.flow.collect

@Composable
fun ConsoleMonitor(viewModel: LineViewModel) {
    val lines = remember { mutableStateListOf<Line>() }
    LaunchedEffect(Unit) {
        viewModel.lineFlow.collect {
            lines.add(it)
        }
    }

    BoxWithConstraints(
        Modifier.fillMaxWidth(0.7f).fillMaxHeight().background(Color(0xFF272A2B)).padding(5.dp)
    ) {
        val lazyListState = rememberLazyListState()

        Box(Modifier.fillMaxSize()) {
            Lines(lines, lazyListState)
        }

        Box(Modifier.align(Alignment.CenterEnd).fillMaxHeight()) {
            Scrollbar(lazyListState)
        }
    }
}