package main.java.me.Chatchayut.GUIMenu.events;

import main.java.me.Chatchayut.GUIMenu.Menu;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

public class spawnEvents implements Listener {
    private final Menu plugin;

    public spawnEvents(Menu plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e){
        Player player = e.getPlayer();
        Location location = (Location) plugin.getConfig().get("spawn");
        if (plugin.getConfig().getBoolean("teleport_player_to_spawn_when_join")) {
            if (location != null){
                player.teleport(location);
            }
        }
    }

    @EventHandler
    public void onPlayerRespawn(PlayerRespawnEvent e){
        Player player = e.getPlayer();
        Location location = (Location) plugin.getConfig().get("spawn");
        if (location != null) {
            e.setRespawnLocation(location);
        }
    }
}
