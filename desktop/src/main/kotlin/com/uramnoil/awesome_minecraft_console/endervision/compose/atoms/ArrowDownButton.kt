package com.uramnoil.awesome_minecraft_console.endervision.compose.atoms

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.material.Icon
import androidx.compose.material.IconToggleButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun ArrowDownToggleButton(
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    enabled: Boolean = true,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    contentDescription: String = "",
) {
    IconToggleButton(checked, onCheckedChange, Modifier, enabled, interactionSource) {
        val tint = animateColorAsState(
            if (checked) Color(0xFF01F9AD) else Color(0x01F9AD).copy(0.2F)
        )
        Icon(Icons.Filled.ArrowDropDown, contentDescription, Modifier, tint.value)
    }
}