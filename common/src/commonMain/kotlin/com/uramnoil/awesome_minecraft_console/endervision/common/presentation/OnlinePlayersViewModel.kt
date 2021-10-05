package com.uramnoil.awesome_minecraft_console.endervision.common.presentation

import com.uramnoil.awesome_minecraft_console.endervision.common.usecase.OnlinePlayers
import kotlinx.coroutines.flow.Flow

data class OnlinePlayersViewModel(val flow: Flow<OnlinePlayers>)
