package Thailand.Chatchayut.Menu.events;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class Click implements Listener {
    @EventHandler
    public void click(InventoryClickEvent clickEvent) {

        Player player = (Player) clickEvent.getWhoClicked();
        if (clickEvent.getCurrentItem() == null) return;
        if (clickEvent.getCursor().equals(Material.NETHER_STAR)){
            if (clickEvent.isRightClick()){
                Bukkit.dispatchCommand(player, "menu");
                clickEvent.setCancelled(true);
            }
            if (clickEvent.isLeftClick()){
                Bukkit.dispatchCommand(player, "menu");
                clickEvent.setCancelled(true);
            }
        }

        if (clickEvent.getClickedInventory().getTitle().equalsIgnoreCase("Menu")) {
            switch (clickEvent.getCurrentItem().getType()) {
                case COMPASS:
                    player.closeInventory();
                    player.sendMessage("§7Sending to lobby..");
                    Bukkit.dispatchCommand(player, "spawn");
                    break;
                case BARRIER:
                    player.closeInventory();
                    break;
            }

            clickEvent.setCancelled(true);
        }
    }

    @EventHandler
    public void userInventoryClick(PlayerInteractEvent event) throws Exception {
        Player player = event.getPlayer();
        Action action = event.getAction();
        ItemStack  itemStack = event.getItem();
        if (itemStack.getType() == Material.NETHER_STAR) Bukkit.dispatchCommand(player, "menu");

    }

    @EventHandler
    public void onPlayerDropItem(PlayerDropItemEvent event){
        Player player = event.getPlayer();

        if(player.getInventory().contains(Material.NETHER_STAR));
            event.setCancelled(true);
    }
}



