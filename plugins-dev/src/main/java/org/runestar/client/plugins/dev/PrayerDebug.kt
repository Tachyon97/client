package org.runestar.client.plugins.dev

import org.runestar.client.api.util.DisposablePlugin
import org.runestar.client.api.Fonts
import org.runestar.client.game.api.Prayer
import org.runestar.client.game.api.live.Canvas
import org.runestar.client.game.api.live.Prayers
import org.runestar.client.plugins.spi.PluginSettings
import java.awt.Color

class PrayerDebug : DisposablePlugin<PluginSettings>() {

    override val defaultSettings = PluginSettings()

    override fun onStart() {
        add(Canvas.repaints.subscribe { g ->
            val x = 5
            var y = 40
            g.font = Fonts.PLAIN_12
            g.color = Color.WHITE
            val strings = ArrayList<String>()
            Prayer.values().filter { Prayers.isEnabled(it) }.mapTo(strings) { it.toString() }
            strings.forEach { s ->
                g.drawString(s, x, y)
                y += g.font.size + 5
            }
        })
    }
}