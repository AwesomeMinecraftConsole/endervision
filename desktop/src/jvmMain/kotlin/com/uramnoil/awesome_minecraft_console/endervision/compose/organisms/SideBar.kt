package com.uramnoil.awesome_minecraft_console.endervision.compose.molecules

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.uramnoil.awesome_minecraft_console.endervision.compose.viewmodel.CommandViewModel
import kotlinx.coroutines.launch

@Composable
fun SideBar(onClick: suspend (String) -> Unit) {
    val commandViewModel = remember { CommandViewModel("") }
    val coroutineScope = rememberCoroutineScope()

    Box(Modifier.fillMaxWidth(0.3f)) {
        Column {
            var commandField by remember { mutableStateOf("") }
            TextField(commandField, onValueChange = {
                commandField = it
                commandViewModel.command = it
            })
            Button(
                onClick = {
                    coroutineScope.launch {
                        onClick(commandViewModel.command)
                    }
                }
            ) {
                Text("Execute")
            }
        }
    }
}
