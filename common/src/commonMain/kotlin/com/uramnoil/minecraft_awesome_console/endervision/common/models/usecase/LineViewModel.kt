package com.uramnoil.minecraft_awesome_console.endervision.common.models.usecase

import kotlinx.coroutines.flow.Flow

data class Line(val line: String)

class LineViewModel(val lineFlow: Flow<Line>)