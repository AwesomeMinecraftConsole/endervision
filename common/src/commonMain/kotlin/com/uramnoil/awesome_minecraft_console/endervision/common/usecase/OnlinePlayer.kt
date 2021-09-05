package com.uramnoil.awesome_minecraft_console.endervision.common.usecase

data class Id(val value: String)
data class Name(val value: String)
data class Ping(val value: UInt)

data class OnlinePlayer(val id: Id, val name: Name, val ping: Ping)

data class OnlinePlayers(val value: List<OnlinePlayer>)