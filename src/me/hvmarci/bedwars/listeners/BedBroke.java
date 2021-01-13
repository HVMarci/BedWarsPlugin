package me.hvmarci.bedwars.listeners;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import me.hvmarci.bedwars.Main;
import me.hvmarci.bedwars.Team;
import me.hvmarci.bedwars.TeamType;

public class BedBroke implements Listener {
	
	@EventHandler
	public void bedBreakEvent(BlockBreakEvent e) {
		if (Main.megyAJatek) {
			Block b = e.getBlock();
			Player p = e.getPlayer();
			World w = Bukkit.getWorld(Main.mainWorld);

			if (b.getLocation().getWorld().equals(w)) {
				if (b.getType().equals(Material.RED_BED)) {
					if (Team.getTeamType(p) == TeamType.RED) {
						e.setCancelled(true);
						return;
					}
					
					e.setDropItems(false);
					
					w.getPlayers().forEach(i -> {
						i.sendMessage("§cA §4piros §cágyat kiütötte " + p.getDisplayName() + "§c!");
					});
					
					Team.getRedTeam().getPlayers().forEach(i -> {
						Player ap = (Player) i;
						ap.sendTitle("", p.getDisplayName() + "§c kiütötte az ágyadat!", 1, 78, 1);
					});
					
					Team.halottTeam(TeamType.RED);
				} else if (b.getType().equals(Material.BLUE_BED)) {
					if (Team.getTeamType(p) == TeamType.BLUE) {
						e.setCancelled(true);
						return;
					}
					
					e.setDropItems(false);
					
					w.getPlayers().forEach(i -> {
						i.sendMessage("§cA §bkék §cágyat kiütötte " + p.getDisplayName() + "§c!");
					});
					
					Team.getBlueTeam().getPlayers().forEach(i -> {
						Player ap = (Player) i;
						ap.sendTitle("", p.getDisplayName() + "§c kiütötte az ágyadat!", 1, 78, 1);
					});
					
					Team.halottTeam(TeamType.BLUE);
				} else if (b.getType().equals(Material.YELLOW_BED)) {
					if (Team.getTeamType(p) == TeamType.YELLOW) {
						e.setCancelled(true);
						return;
					}
					
					e.setDropItems(false);
					
					w.getPlayers().forEach(i -> {
						i.sendMessage("§cA §6sárga §cágyat kiütötte " + p.getDisplayName() + "§c!");
					});
					
					Team.getYellowTeam().getPlayers().forEach(i -> {
						Player ap = (Player) i;
						ap.sendTitle(p.getDisplayName() + "§c kiütötte az ágyadat!", "", 1, 78, 1);
					});
					
					Team.halottTeam(TeamType.YELLOW);
				} else if (b.getType().equals(Material.GREEN_BED)) {
					if (Team.getTeamType(p) == TeamType.GREEN) {
						e.setCancelled(true);
						return;
					}
					
					e.setDropItems(false);
					
					w.getPlayers().forEach(i -> {
						i.sendMessage("§cA §2zöld §cágyat kiütötte " + p.getDisplayName() + "§c!");
					});
					
					Team.getGreenTeam().getPlayers().forEach(i -> {
						Player ap = (Player) i;
						ap.sendTitle(p.getDisplayName() + "§c kiütötte az ágyadat!", "", 1, 78, 1);
					});
					
					Team.halottTeam(TeamType.GREEN);
				}
			}
		}
	}

}
