package tv.banko.tutorialreloaded;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import tv.banko.tutorialreloaded.backpack.BackpackManager;
import tv.banko.tutorialreloaded.commands.BackpackCommand;
import tv.banko.tutorialreloaded.commands.TimerCommand;
import tv.banko.tutorialreloaded.listeners.ExplosionListeners;
import tv.banko.tutorialreloaded.listeners.JoinListener;
import tv.banko.tutorialreloaded.listeners.QuitListener;
import tv.banko.tutorialreloaded.timer.Timer;
import tv.banko.tutorialreloaded.utils.Config;

public final class Main extends JavaPlugin {

    private static Main instance;

    private Timer timer;
    private Config config;
    private BackpackManager backpackManager;

    @Override
    public void onLoad() {
        instance = this;
        config = new Config();
    }

    @Override
    public void onEnable() {
        Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_RED + "HALLO!");

        PluginManager manager = Bukkit.getPluginManager();
        manager.registerEvents(new JoinListener(), this);
        manager.registerEvents(new QuitListener(), this);
        manager.registerEvents(new ExplosionListeners(), this);

        getCommand("timer").setExecutor(new TimerCommand());
        getCommand("backpack").setExecutor(new BackpackCommand());

        timer = new Timer();
        backpackManager = new BackpackManager();
    }

    @Override
    public void onDisable() {
        timer.save();
        backpackManager.save();

        config.save();
    }

    public static Main getInstance() {
        return instance;
    }

    public Config getConfiguration() {
        return config;
    }

    public Timer getTimer() {
        return timer;
    }

    public BackpackManager getBackpackManager() {
        return backpackManager;
    }
}
