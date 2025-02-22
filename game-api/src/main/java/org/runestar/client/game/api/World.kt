package org.runestar.client.game.api

import org.runestar.client.game.api.live.Worlds
import org.runestar.client.game.raw.access.XWorld
import org.runestar.client.web.hiscore.HiscoreEndpoint

inline class World(val accessor: XWorld) {

    val id: Int get() = accessor.id

    val properties: Int get() = accessor.properties

    val host: String get() = accessor.host

    val activity: String get() = accessor.activity

    val location: Int get() = accessor.location

    val population: Int get() = accessor.population

    val hiscoreEndpoint: HiscoreEndpoint get() = Worlds.hiscoreEndpoint(properties)

    override fun toString(): String = "World($id)"
}