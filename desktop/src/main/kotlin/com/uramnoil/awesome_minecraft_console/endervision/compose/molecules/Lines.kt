package com.uramnoil.awesome_minecraft_console.endervision.compose.atoms

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.uramnoil.awesome_minecraft_console.endervision.common.usecase.Line

@Composable
fun Lines(lines: List<Line>, lazyListState: LazyListState) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        state = lazyListState,
        verticalArrangement = Arrangement.spacedBy(5.dp)
    ) {
        items(lines) {
            Line(it)
        }
    }
}