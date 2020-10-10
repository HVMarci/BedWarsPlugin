package me.hvmarci.bedwars.Listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import me.hvmarci.bedwars.Main;

public class FrostOrNot implements Listener {
	@EventHandler
	public void onMove(PlayerMoveEvent e) {
		if (Main.frost.contains(e.getPlayer().getName())) {
			e.setCancelled(true);
		}
	}
}
