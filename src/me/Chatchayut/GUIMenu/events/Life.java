package me.Chatchayut.GUIMenu.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

public class Life implements Listener {
    @EventHandler
    public void onPlayerRespawn(PlayerRespawnEvent event){
        //events
        event.getPlayer().getInventory().clear(event.getPlayer().getInventory().getHeldItemSlot() + 8);
        event.getPlayer().getInventory().setItem(8, MenuItem.getMenu());
    }

    //PlayerDeathEvent will be add soon
    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event){
        if(event.getEntity().getInventory().contains(MenuItem.getMenu())){
            event.getDrops().remove(MenuItem.getMenu());
        }
    }
}
