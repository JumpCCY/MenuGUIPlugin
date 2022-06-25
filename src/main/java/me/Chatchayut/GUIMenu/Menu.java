package main.java.me.Chatchayut.GUIMenu;

import main.java.me.Chatchayut.GUIMenu.commands.MenuCommand;
import main.java.me.Chatchayut.GUIMenu.commands.giveMenu;
import main.java.me.Chatchayut.GUIMenu.commands.spawn;
import main.java.me.Chatchayut.GUIMenu.events.Click;
import main.java.me.Chatchayut.GUIMenu.events.Life;
import main.java.me.Chatchayut.GUIMenu.events.onJQ;
import main.java.me.Chatchayut.GUIMenu.events.spawnEvents;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;


public class Menu extends JavaPlugin {
    @Override
    public void onEnable() {
        getLogger().info("========================");
        getLogger().info("STARTING JumpCCY's GUI MENU");

        getConfig().options().copyDefaults(true);
        saveConfig();

        getCommand("menu").setExecutor(new MenuCommand());
        getCommand("givemenu").setExecutor(new giveMenu());
        getCommand("spawn").setExecutor(new spawn(this));
        getCommand("setspawn").setExecutor(new spawn(this));

        getServer().getPluginManager().registerEvents(new spawnEvents(this), this);

        getServer().getPluginManager().registerEvents(new Click(), this);
        getServer().getPluginManager().registerEvents(new onJQ(), this);
        getServer().getPluginManager().registerEvents(new Life(), this);
        getLogger().info("========================");
        getLogger().info(ChatColor.GREEN + "Welcome to the first plugin developed by JumpCCY");
        getLogger().info("========================");
    }

    @Override
    public void onDisable() {
        getLogger().info("------------------------");
        getLogger().info(ChatColor.RED + "DISABLED JumpCCY GUI MENU plugin, Bye!");
        getLogger().info("------------------------");
    }


}
