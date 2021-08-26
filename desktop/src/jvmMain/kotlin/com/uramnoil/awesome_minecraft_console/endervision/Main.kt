import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

fun main() = app()

fun app() = application {
    val serverName = remember { mutableStateOf("") }
    Window(onCloseRequest = ::exitApplication, title = "EnderVision") {
        val verticalScrollState = rememberLazyListState()

        BoxWithConstraints(Modifier.fillMaxSize().background(Color(0xFF464D49))) {
            val lines = remember { mutableStateOf(listOf<String>()) }
            val hoge = (0..100).toList().map { "Line$it" }

            Row {
                BoxWithConstraints(
                    Modifier.fillMaxWidth(0.7f).fillMaxHeight().background(Color(0xFF272A2B)).padding(5.dp)
                ) {
                    LazyColumn(modifier = Modifier.fillMaxSize(), state = verticalScrollState, verticalArrangement = Arrangement.spacedBy(5.dp)) {
                        items(hoge) {
                            Text(it, color = Color.White, modifier = Modifier.fillMaxWidth())
                        }
                    }

                    VerticalScrollbar(rememberScrollbarAdapter(verticalScrollState), Modifier.align(Alignment.CenterEnd), style = ScrollbarStyle(
                        minimalHeight = 16.dp,
                        thickness = 8.dp,
                        shape = RoundedCornerShape(3.dp),
                        hoverDurationMillis = 100,
                        hoverColor = Color.White.copy(0.7f),
                        unhoverColor = Color.White.copy(0.1f)
                    ))
                }
                Box(Modifier.fillMaxWidth(0.3f)) {
                    Button(onClick = {
                        lines.value += ("hoge")
                    }) {
                        Text("hoge")
                    }
                }
            }
        }
    }
}