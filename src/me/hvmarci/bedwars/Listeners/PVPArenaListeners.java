package me.hvmarci.bedwars.Listeners;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.player.PlayerRespawnEvent;

import me.hvmarci.bedwars.Main;

public class PVPArenaListeners implements Listener{
	
	private boolean isInArena(Location e) {
		if (e.getWorld() == Bukkit.getServer().getWorld(Main.pvpWorld)) {
			return true;
		} else {
			return false;
		}
	}
	
	@EventHandler
	public void noFallDamage(EntityDamageEvent e) {
		if (e.getCause() == DamageCause.FALL && isInArena(e.getEntity().getLocation())) {
			e.setCancelled(true);
		}
	}
	
	@EventHandler
	public void onBreak(BlockBreakEvent e) {
		if (isInArena(e.getBlock().getLocation()) && !Main.arenaPlacedBlocks.contains(e.getBlock())) {
			e.setCancelled(true);
		} else {
			Main.arenaPlacedBlocks.remove(e.getBlock());
		}
	}
	
	@EventHandler
	public void onPlace(BlockPlaceEvent e) {
		if (isInArena(e.getBlock().getLocation())) {
			Main.arenaPlacedBlocks.add(e.getBlock());
		}
		
	}
	
	@EventHandler
	public void onDeath(PlayerRespawnEvent e) {
		//if (isInArena(e.getPlayer().getLocation())) {
			Location loc = new Location(Bukkit.getWorld(Main.pvpWorld), 0.5, 64, 0.5);
			e.getPlayer().setGameMode(GameMode.SURVIVAL);
			e.setRespawnLocation(loc);
			
		//}
	}
	
}
