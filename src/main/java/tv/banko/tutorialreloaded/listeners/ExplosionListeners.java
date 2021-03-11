package tv.banko.tutorialreloaded.listeners;

import org.bukkit.Material;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.Objects;

public class ExplosionListeners implements Listener {

    @EventHandler
    public void onEntityExplode(EntityExplodeEvent event) {
        if(!(event.getEntity() instanceof Creeper)) {
            return;
        }
        event.blockList().clear();
    }

    @EventHandler
    public void onPlace(BlockPlaceEvent event) {
        if(!event.getBlockPlaced().getType().equals(Material.TNT)) {
            return;
        }
        event.getBlockPlaced().setType(Material.AIR);
        TNTPrimed tnt = (TNTPrimed) event.getBlockPlaced().getWorld().spawnEntity(event.getBlockPlaced().getLocation(), EntityType.PRIMED_TNT);
        tnt.setFuseTicks(0);
    }

    @EventHandler
    public void onInteract(PlayerInteractEvent event) {
        if(!event.hasItem()) {
            return;
        }
        if(!event.hasBlock()) {
            return;
        }
        if(!event.getPlayer().isOp()) {
            return;
        }
        if(!Objects.requireNonNull(event.getItem()).getType().equals(Material.FIRE_CHARGE)) {
            return;
        }
        TNTPrimed tnt = (TNTPrimed) Objects.requireNonNull(event.getClickedBlock()).getWorld().spawnEntity(event.getClickedBlock().getLocation(), EntityType.PRIMED_TNT);
        tnt.setIsIncendiary(true);
        tnt.setFuseTicks(0);
        tnt.setYield(1000);
    }
}
