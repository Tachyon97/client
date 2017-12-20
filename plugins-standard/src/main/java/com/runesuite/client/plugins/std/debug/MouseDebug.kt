package com.runesuite.client.plugins.std.debug

import com.runesuite.client.game.api.live.LiveCanvas
import com.runesuite.client.game.api.live.Mouse
import com.runesuite.client.game.raw.Client
import com.runesuite.client.plugins.PluginSettings
import com.runesuite.client.plugins.utils.ColorForm
import com.runesuite.client.plugins.utils.DisposablePlugin
import com.runesuite.client.plugins.utils.FontForm
import java.awt.Font

class MouseDebug : DisposablePlugin<MouseDebug.Settings>() {

    override val defaultSettings = Settings()

    override fun start() {
        super.start()
        add(LiveCanvas.repaints.subscribe { g ->
            val x = 5
            var y = 40
            g.font = settings.font.get()
            g.color = settings.color.get()
            val strings = ArrayList<String>()

            strings.apply {
                add("mouse")
                add("location: ${Mouse.location}")
                add("viewportLocation: ${Mouse.viewportLocation}")
                add("crossColor: ${Mouse.crossColor}")
                add("crossState: ${Mouse.crossState}")
                add("isInViewport: ${Mouse.isInViewport}")
                add("entityCount: ${Mouse.entityCount}")
                add("entityTags:")
                Mouse.entityTags.mapTo(this) { it.toString() }
            }

            strings.forEach { s ->
                g.drawString(s, x, y)
                y += g.font.size + 5
            }
        })
    }

    class Settings : PluginSettings() {
        val font = FontForm(Font.SANS_SERIF, FontForm.BOLD, 15f)
        val color = ColorForm()
    }
}