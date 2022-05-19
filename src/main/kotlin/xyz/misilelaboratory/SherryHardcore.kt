package xyz.misilelaboratory

import org.bukkit.GameRule
import org.bukkit.plugin.java.JavaPlugin
import java.io.File

@Suppress("unused")
class SherryHardcore: JavaPlugin() {
    override fun onEnable() {
        val worlds = listOf("world", "world_nether", "world_the_end")
        for (w in worlds) {
            val file = File(w)
            if (file.exists()) {
                file.deleteRecursively()
            }
        }
        server.pluginManager.registerEvents(SherryHardcoreHandler(server), this)
        for (world in server.worlds) {
            world.setGameRule(GameRule.NATURAL_REGENERATION, false)
        }
    }
}
