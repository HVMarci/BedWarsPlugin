package me.hvmarci.bedwars.Listeners;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.plugin.Plugin;

import me.hvmarci.bedwars.Main;
import me.hvmarci.bedwars.Team;

public class DeathListener implements Listener {

	private boolean isInGame(World w) {
		if (w == Bukkit.getWorld(Main.mainWorld)) {
			return true;
		} else {
			return false;
		}
	}
	
	HashMap<Player, Integer> h = new HashMap<>();
	
	@EventHandler
	public void onDeath(PlayerDeathEvent e) {
		Player p = e.getEntity();
		World w = p.getWorld();

		if (isInGame(w)) {

			e.setCancelled(true);

			p.setGameMode(GameMode.SPECTATOR);

			Plugin plugin = Bukkit.getPluginManager().getPlugin(Main.pluginName);
			
			h.put(p, plugin.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {

				int respawnTime = 6;

				@Override
				public void run() {
					respawnTime--;
					p.sendTitle("§cRespawning in §a" + (respawnTime), "", 1, 18, 1);
					if (respawnTime == 0) {
						plugin.getServer().getScheduler().cancelTask(h.get(p));
						p.teleport(Main.spawnLocs.get(Team.getTeamType(p)));
						h.remove(p);
						p.setGameMode(GameMode.SURVIVAL);
					}
				}
			}, 0, 20L));
		}

	}
}
