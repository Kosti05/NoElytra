package dev.kosti.noElytra.listeners;

import com.destroystokyo.paper.event.player.PlayerArmorChangeEvent;
import dev.kosti.noElytra.NoElytra;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class PlayerArmorChangedListener implements Listener {

    private final NoElytra noElytra;

    public PlayerArmorChangedListener(NoElytra noElytra) {
        this.noElytra = noElytra;
    }

    @EventHandler
    public void onPlayerArmorChangedEvent(PlayerArmorChangeEvent event) {
        Player player = event.getPlayer();

        if (event.getNewItem().getType() != Material.ELYTRA) {
            return;
        }

        ItemStack elytra = event.getNewItem();

        player.sendMessage(noElytra.PREFIX + "§cYou are not allowed to equip the elytra.");
        player.getInventory().setItem(EquipmentSlot.CHEST, new ItemStack(Material.AIR));
        player.getWorld().dropItem(player.getLocation(), elytra);
    }

}
