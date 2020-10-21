package me.hvmarci.bedwars.Listeners;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import me.hvmarci.bedwars.Main;

public class DeathListener implements Listener {
	
	private boolean isInGame(World w) {
		if (w == Bukkit.getWorld(Main.mainWorld)) {
			return true;
		} else {
			return false;
		}
	}
	
	@EventHandler
	public void onDeath(PlayerDeathEvent e) {
		Player p = e.getEntity();
		World w = p.getWorld();
		Location respawnLoc = new Location(Bukkit.getWorld(Main.mainWorld), 0.5, 64, 0.5);
		
		if (isInGame(w)) {
			
			e.setCancelled(true);
			
			p.teleport(respawnLoc);
			p.setGameMode(GameMode.SPECTATOR);
		}
		
	}
}
