package tv.banko.tutorialreloaded;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import tv.banko.tutorialreloaded.commands.TimerCommand;
import tv.banko.tutorialreloaded.listeners.JoinListener;
import tv.banko.tutorialreloaded.listeners.QuitListener;
import tv.banko.tutorialreloaded.timer.Timer;

public final class Main extends JavaPlugin {

    private static Main instance;

    private Timer timer;

    @Override
    public void onLoad() {
        instance = this;
    }

    @Override
    public void onEnable() {
        Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_RED + "HALLO!");

        PluginManager manager = Bukkit.getPluginManager();
        manager.registerEvents(new JoinListener(), this);
        manager.registerEvents(new QuitListener(), this);

        getCommand("timer").setExecutor(new TimerCommand());

        timer = new Timer(false, 0);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static Main getInstance() {
        return instance;
    }

    public Timer getTimer() {
        return timer;
    }
}
