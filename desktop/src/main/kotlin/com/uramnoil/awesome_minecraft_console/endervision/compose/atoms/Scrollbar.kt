package com.uramnoil.awesome_minecraft_console.endervision.compose.atoms

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.ScrollbarStyle
import androidx.compose.foundation.VerticalScrollbar
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollbarAdapter
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun Scrollbar(lazyListState: LazyListState) {
    VerticalScrollbar(
        adapter = rememberScrollbarAdapter(lazyListState),
        style = ScrollbarStyle(
            minimalHeight = 16.dp,
            thickness = 8.dp,
            shape = RoundedCornerShape(3.dp),
            hoverDurationMillis = 100,
            hoverColor = Color.White.copy(0.7f),
            unhoverColor = Color.White.copy(0.1f)
        )
    )
}

@Preview
@Composable
fun PreviewScrolbar() {
    BoxWithConstraints(Modifier.fillMaxSize()) {
        val scrollableState = rememberLazyListState()
        val list = (1..100).map(Int::toString).toMutableList()

        BoxWithConstraints(Modifier.fillMaxSize()) {
            LazyColumn(state = scrollableState) {
                items(list) {
                    Text(it)
                }
            }
        }
        Box(Modifier.fillMaxHeight().align(Alignment.CenterEnd)) {
            Scrollbar(scrollableState)
        }
    }
}