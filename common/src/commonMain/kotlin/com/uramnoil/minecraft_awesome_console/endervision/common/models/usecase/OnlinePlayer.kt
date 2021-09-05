package com.uramnoil.minecraft_awesome_console.endervision.common.models.usecase

data class Id(val value: String)
data class Name(val value: String)
data class Ping(val value: UInt)

data class OnlinePlayer(val id: Id, val name: Name, val ping: Ping)
