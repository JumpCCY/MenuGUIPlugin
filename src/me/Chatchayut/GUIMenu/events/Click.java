package me.Chatchayut.GUIMenu.events;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class Click implements Listener {
    @EventHandler
    public void click(InventoryClickEvent clickEvent) {

        //nether star menu
        Player player = (Player) clickEvent.getWhoClicked();
        if (clickEvent.getCurrentItem() == null) return;
        //items in menu
        if (clickEvent.getClickedInventory().getTitle().equalsIgnoreCase("Menu")) {
            switch (clickEvent.getCurrentItem().getType()) {
                case COMPASS:
                    player.sendMessage("§7Sending to lobby..");
                    Bukkit.dispatchCommand(player, "spawn");
                    player.closeInventory();
                    break;
                case BARRIER:
                    player.closeInventory();
                    break;
            }
            clickEvent.setCancelled(true);
        }
    }

    @EventHandler
    public void userInventoryClick(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        if (player.getItemInHand().getType().equals(Material.NETHER_STAR)) Bukkit.dispatchCommand(event.getPlayer(), "menu");
    }

    @EventHandler
    public void userDrop(PlayerDropItemEvent event) {
        Player player = event.getPlayer();
        if (player.getInventory().getHeldItemSlot() == 8) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void PlayerItemHeldEvent(InventoryClickEvent event) {
        if (event.getCurrentItem() == null) return;
            if (event.getCurrentItem().getType().equals(Material.NETHER_STAR)) {
                if (event.getClick().isShiftClick()) Bukkit.dispatchCommand(event.getWhoClicked(), "menu");
                if (event.getClick().isRightClick()) Bukkit.dispatchCommand(event.getWhoClicked(), "menu");
                if (event.getClick().isLeftClick()) Bukkit.dispatchCommand(event.getWhoClicked(), "menu");
                if (event.getSlot() == 8) event.setCancelled(true);
            }
    }
}
