package tech.secretgarden;

import dev.drawethree.deathchestpro.DeathChestPro;
import dev.drawethree.deathchestpro.api.event.DeathChestPreCreateEvent;
import dev.drawethree.deathchestpro.managers.DeathChestManager;
import io.github.thebusybiscuit.slimefun4.utils.SlimefunUtils;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;

import java.util.*;

public class NewItems implements Listener {
    private final DeathChestPro plugin = DeathChestPro.getInstance();
    private final DeathChestManager deathChestManager = new DeathChestManager(plugin);
    private static final HashMap<UUID, Collection<ItemStack>> map = new HashMap<>();

    @EventHandler
    public void dcDeath(DeathChestPreCreateEvent e) {
        List<ItemStack> items = e.getContents();
        UUID id = e.getPlayer().getUniqueId();
        Collection<ItemStack> itemsList = new ArrayList<>();

        Iterator<ItemStack> iterator = items.iterator();
        while (iterator.hasNext()) {
            ItemStack item = iterator.next();
            if (SlimefunUtils.isSoulbound(item)) {
                iterator.remove();
                itemsList.add(item);
            }
            if (!itemsList.isEmpty()) {
                map.put(id, itemsList);
            }
        }
    }

    @EventHandler
    public void respawn(PlayerRespawnEvent e) {
        UUID id = e.getPlayer().getUniqueId();
        if (map.containsKey(id)) {
            Collection<ItemStack> items = map.get(id);
            for (ItemStack item : items) {
                e.getPlayer().getInventory().addItem(item);
            }
        }
    }
}



