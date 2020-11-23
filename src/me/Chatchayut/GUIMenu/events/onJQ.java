package me.Chatchayut.GUIMenu.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class onJQ implements Listener {
    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        //events
        event.getPlayer().getInventory().clear(event.getPlayer().getInventory().getHeldItemSlot() + 8);
        event.getPlayer().getInventory().setItem(8, MenuItem.getMenu());

    }
}
