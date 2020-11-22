package me.Chatchayut.GUIMenu.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class MenuCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (commandSender instanceof Player) {
            Inventory menu = Bukkit.createInventory((InventoryHolder) commandSender, 54, "Menu");

            //items
            ItemStack lobby = new ItemStack(Material.COMPASS);
            ItemStack close = new ItemStack(Material.BARRIER);
            ItemStack background = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);

            //metadata lobby
            ItemMeta lobby_meta = lobby.getItemMeta();
            lobby_meta.addEnchant(Enchantment.DURABILITY, 0, false);
            lobby_meta.setDisplayName("§6§lLOBBY");
            ArrayList<String> lobby_lore = new ArrayList<>();
            lobby_lore.add("");
            lobby_lore.add("§7Return to the main lobby");
            lobby_meta.setLore(lobby_lore);
            lobby.setItemMeta(lobby_meta);
            lobby_meta.removeEnchant(Enchantment.DURABILITY);

            //metadata close
            ItemMeta close_meta = close.getItemMeta();
            close_meta.setDisplayName(ChatColor.RED + "Close");
            close.setItemMeta(close_meta);

            //metadata background
            ItemMeta bg_meta = background.getItemMeta();
            bg_meta.setDisplayName(" ");
            background.setItemMeta(bg_meta);

            for (int i = 0; i < 54; i++) {
                menu.setItem(i, background);
            }

            menu.setItem(22, lobby);
            menu.setItem(49, close);

            ((Player) commandSender).openInventory(menu);
        }
        return true;
    }
}
