package tv.banko.tutorialreloaded;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import tv.banko.tutorialreloaded.listeners.JoinListener;
import tv.banko.tutorialreloaded.listeners.QuitListener;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_RED + "HALLO!");

        PluginManager manager = Bukkit.getPluginManager();
        manager.registerEvents(new JoinListener(), this);
        manager.registerEvents(new QuitListener(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
