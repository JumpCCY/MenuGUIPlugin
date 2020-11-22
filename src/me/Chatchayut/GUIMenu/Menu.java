package me.Chatchayut.GUIMenu;

import me.Chatchayut.GUIMenu.commands.MenuCommand;
import me.Chatchayut.GUIMenu.commands.giveMenu;
import me.Chatchayut.GUIMenu.events.Click;
import me.Chatchayut.GUIMenu.events.Life;
import me.Chatchayut.GUIMenu.events.onJQ;
import org.bukkit.plugin.java.JavaPlugin;


public class Menu extends JavaPlugin {
    @Override
    public void onEnable() {
        getLogger().info("========================");
        getLogger().info("STARTING JJUMP88 GUI MENU");
        getCommand("menu").setExecutor(new MenuCommand());
        getServer().getPluginManager().registerEvents(new Click(), this);
        getServer().getPluginManager().registerEvents(new onJQ(), this);
        getServer().getPluginManager().registerEvents(new Life(), this);
        this.getCommand("givemenu").setExecutor(new giveMenu());
        getLogger().info("========================");
        getLogger().info("Welcome to the first plugin developed by jjump88");
        getLogger().info("========================");
    }

    @Override
    public void onDisable() {
        getLogger().info("DISABLED, Bye!");
    }


}
