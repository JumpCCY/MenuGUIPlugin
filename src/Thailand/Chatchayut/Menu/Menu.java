package Thailand.Chatchayut.Menu;

import Thailand.Chatchayut.Menu.commands.MenuCommand;
import Thailand.Chatchayut.Menu.events.Click;
import Thailand.Chatchayut.Menu.events.onJQ;
import org.bukkit.plugin.java.JavaPlugin;


public class Menu extends JavaPlugin {
    @Override
    public void onEnable() {
        getLogger().info("STARTING");
        getCommand("menu").setExecutor(new MenuCommand());
        getServer().getPluginManager().registerEvents(new Click(), this);
        getServer().getPluginManager().registerEvents(new onJQ(), this);
        getLogger().info("========================");
        getLogger().info("Welcome to the first plugin developed by jjump88");
        getLogger().info("========================");
    }

    @Override
    public void onDisable() {
        getLogger().info("DISABLED, Bye!");
    }


}
