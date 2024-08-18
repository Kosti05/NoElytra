package dev.kosti.noElytra;

import dev.kosti.noElytra.listeners.PlayerArmorChangedListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class NoElytra extends JavaPlugin {

    public String PREFIX() {return "§7[§6NoElytra§7]§r ";}

    @Override
    public void onEnable() {
        // Plugin startup logic
        registerListener();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public void registerListener() {
        PluginManager pluginManager = Bukkit.getPluginManager();
        pluginManager.registerEvents(new PlayerArmorChangedListener(this), this);
    }
}
