package org.opencommunity.goodpatcher;

import org.bukkit.Material;
import org.bukkit.entity.Boat;
import org.bukkit.entity.Entity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main extends JavaPlugin implements Listener {

    private static final Set<Material> WATER_MATERIALS = new HashSet<>(Arrays.asList(
            Material.WATER,
            Material.SEAGRASS,
            Material.TALL_SEAGRASS,
            Material.KELP,
            Material.SEA_PICKLE,
            Material.TURTLE_EGG,
            Material.TUBE_CORAL,
            Material.TUBE_CORAL_FAN,
            Material.BRAIN_CORAL,
            Material.BRAIN_CORAL_FAN,
            Material.BUBBLE_CORAL,
            Material.BUBBLE_CORAL_FAN,
            Material.FIRE_CORAL,
            Material.FIRE_CORAL_FAN,
            Material.HORN_CORAL,
            Material.HORN_CORAL_FAN,
            Material.DEAD_TUBE_CORAL,
            Material.DEAD_BRAIN_CORAL,
            Material.DEAD_BUBBLE_CORAL,
            Material.DEAD_FIRE_CORAL,
            Material.DEAD_HORN_CORAL,
            Material.DEAD_TUBE_CORAL_FAN,
            Material.DEAD_BRAIN_CORAL_FAN,
            Material.DEAD_BUBBLE_CORAL_FAN,
            Material.DEAD_FIRE_CORAL_FAN,
            Material.DEAD_HORN_CORAL_FAN
    ));

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
        return WATER_MATERIALS.contains(material);
    }
}
