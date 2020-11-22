package me.Chatchayut.GUIMenu.events;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class Life implements Listener {
    @EventHandler
    public void onPlayerRespawn(PlayerRespawnEvent event){
        ItemStack menu = new ItemStack(Material.NETHER_STAR);

        ItemMeta menu_meta = menu.getItemMeta();
        menu_meta.setDisplayName(ChatColor.GREEN + "Game Menu" + ChatColor.GRAY + " (Right Click)");
        ArrayList<String> menu_lore = new ArrayList<>();
        menu_lore.add(ChatColor.GRAY + "Right Click to bring up the Game Menu!");
        menu_meta.setLore(menu_lore);
        menu.setItemMeta(menu_meta);
        //events
        event.getPlayer().getInventory().clear(event.getPlayer().getInventory().getHeldItemSlot() + 8);
        event.getPlayer().getInventory().setItem(8, menu);

    }
    //PlayerDeathEvent will be add soon
}
