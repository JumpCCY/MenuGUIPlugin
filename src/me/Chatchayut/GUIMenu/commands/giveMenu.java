package me.Chatchayut.GUIMenu.commands;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.logging.Logger;

public class giveMenu implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (commandSender instanceof Player && commandSender.isOp())  {
            PlayerInventory inventory = ((Player) commandSender).getInventory();
            ItemStack menu = new ItemStack(Material.NETHER_STAR);

            ItemMeta menu_meta = menu.getItemMeta();
            menu_meta.setDisplayName(ChatColor.GREEN + "Game Menu" + ChatColor.GRAY + " (Right Click)");
            ArrayList<String> menu_lore = new ArrayList<>();
            menu_lore.add(ChatColor.GRAY + "Right Click to bring up the Game Menu!");
            menu_meta.setLore(menu_lore);
            menu.setItemMeta(menu_meta);

            //events
            inventory.clear(inventory.getHeldItemSlot() + 8);
            inventory.setItem(8, menu);
            commandSender.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + ">> " + ChatColor.RED + "Whoosh!");
            Logger.getLogger(String.valueOf(commandSender)).info("Give " + ((Player) commandSender).getPlayer().getName() + " new menu!");
        }
        else commandSender.sendMessage(ChatColor.DARK_RED + "You do not have access to that command");
        return true;
    }
}
