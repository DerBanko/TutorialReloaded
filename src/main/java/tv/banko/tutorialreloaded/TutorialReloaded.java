package tv.banko.tutorialreloaded;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import tv.banko.tutorialreloaded.commands.TimerCommand;
import tv.banko.tutorialreloaded.listeners.ExplosionListeners;
import tv.banko.tutorialreloaded.listeners.JoinListener;
import tv.banko.tutorialreloaded.listeners.QuitListener;
import tv.banko.tutorialreloaded.timer.Timer;
import tv.banko.tutorialreloaded.utils.Config;

public final class TutorialReloaded extends JavaPlugin {

    private static TutorialReloaded instance;

    private Timer timer;
    private Config config;

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
        timer = new Timer();
    }

    @Override
    public void onDisable() {
        timer.save();
        config.save();
    }

    public Config getConfiguration() {
        return config;
    }

    public static TutorialReloaded getInstance() {
        return instance;
    }

    public Timer getTimer() {
        return timer;
    }
}
