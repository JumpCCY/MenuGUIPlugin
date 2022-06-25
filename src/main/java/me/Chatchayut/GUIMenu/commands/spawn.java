package main.java.me.Chatchayut.GUIMenu.commands;

import main.java.me.Chatchayut.GUIMenu.Menu;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class spawn implements CommandExecutor {

    private final Menu plugin;

    public spawn(Menu plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player){
            if (command.getName().equalsIgnoreCase("setspawn")){
                Player player = (Player) sender;
                Location location = player.getLocation();

                plugin.getConfig().set("spawn", location);
                plugin.saveConfig();
                player.sendMessage(ChatColor.GRAY + "spawn set!");

            } else if (command.getName().equalsIgnoreCase("spawn")) {
                Player player = (Player) sender;
                Location location = (Location) plugin.getConfig().get("spawn");
                if (location != null){
                    player.teleport(location);
                }
                else {
                    player.sendMessage(ChatColor.RED + "Spawn not found");
                }
            }
        }

        return true;
    }
}
