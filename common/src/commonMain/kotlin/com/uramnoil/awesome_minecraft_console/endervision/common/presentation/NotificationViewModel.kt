package com.uramnoil.awesome_minecraft_console.endervision.common.presentation

import com.uramnoil.awesome_minecraft_console.endervision.common.usecase.Notification
import kotlinx.coroutines.flow.Flow

data class NotificationViewModel(val flow: Flow<Notification>)
