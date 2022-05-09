package xyz.misilelaboratory

import org.bukkit.Server
import org.bukkit.attribute.Attribute
import org.bukkit.entity.EntityType
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.entity.EntityDeathEvent
import org.bukkit.event.entity.PlayerDeathEvent
import org.bukkit.event.player.PlayerJoinEvent

class SherryHardcoreHandler(private val server: Server): Listener {

    @EventHandler
    fun onJoin(e: PlayerJoinEvent) {
        val player = e.player
        val attribute = player.getAttribute(Attribute.GENERIC_MAX_HEALTH)
        player.health = 1.toDouble()
        attribute?.baseValue = 1.toDouble()
    }

    @EventHandler
    fun onDeath(e: PlayerDeathEvent) {
        if (!server.isStopping) {
            server.spigot().restart()
        }
    }

    @EventHandler
    fun onEntityDeath(e: EntityDeathEvent) {
        if (e.entityType == EntityType.ENDER_DRAGON && e.entity.killer != null) {
            server.logger.info("wa sherry")
            server.logger.warning("아시는구나")
        }
    }
}