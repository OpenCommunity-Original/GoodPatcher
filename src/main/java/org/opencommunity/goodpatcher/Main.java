package org.opencommunity.goodpatcher;

import org.bukkit.Material;
import org.bukkit.entity.Boat;
import org.bukkit.entity.Entity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
    }

    @Override
    public void onDisable() {
        // Plugin cleanup
    }

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        Entity vehicle = event.getPlayer().getVehicle();
        if (vehicle instanceof Boat && !isWater(event.getTo().getBlock().getType())) {
            vehicle.eject();
        }
    }

    private boolean isWater(Material material) {
        return material == Material.WATER || material == Material.SEAGRASS || material == Material.KELP;
    }
}
