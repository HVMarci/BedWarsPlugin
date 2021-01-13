package me.hvmarci.bedwars.CommandHandlers.Start;

import java.util.HashMap;
import java.util.List;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.bukkit.util.Vector;

import me.hvmarci.bedwars.Main;
import me.hvmarci.bedwars.Team;
import me.hvmarci.bedwars.TeamType;

public class StartGame implements CommandExecutor {

	static Plugin plugin = Bukkit.getPluginManager().getPlugin(Main.pluginName);

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		plugin.getServer().getWorld(Main.mainWorld).getPlayers().forEach(i -> {
			i.setGameMode(GameMode.ADVENTURE);
		});

		// vas
		plugin.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
			public void run() {
				Location sp1 = new Location(plugin.getServer().getWorld(Main.mainWorld), -28, 11, -69);
				Location sp2 = new Location(plugin.getServer().getWorld(Main.mainWorld), -16, 11, 83);
				Location sp3 = new Location(plugin.getServer().getWorld(Main.mainWorld), -87, 11, -6);
				sp1.getWorld().dropItem(sp1, new ItemStack(Material.IRON_INGOT));
				sp2.getWorld().dropItem(sp2, new ItemStack(Material.IRON_INGOT));
				sp3.getWorld().dropItem(sp3, new ItemStack(Material.IRON_INGOT));
			}
		}, 100l, 40l);

		// arany
		plugin.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
			public void run() {
				Location sp1 = new Location(plugin.getServer().getWorld(Main.mainWorld), -28, 11, -69);
				Location sp2 = new Location(plugin.getServer().getWorld(Main.mainWorld), -16, 11, 83);
				Location sp3 = new Location(plugin.getServer().getWorld(Main.mainWorld), -87, 11, -6);
				sp1.getWorld().dropItem(sp1, new ItemStack(Material.GOLD_INGOT));
				sp2.getWorld().dropItem(sp2, new ItemStack(Material.GOLD_INGOT));
				sp3.getWorld().dropItem(sp3, new ItemStack(Material.GOLD_INGOT));
			}
		}, 220l, 160l);

		// smaragd
		plugin.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
			public void run() {
				Location sp1 = new Location(plugin.getServer().getWorld(Main.mainWorld), 5.5, 12, 23.5);
				Location sp2 = new Location(plugin.getServer().getWorld(Main.mainWorld), -24.5, 12, 29.5);
				Location sp3 = new Location(plugin.getServer().getWorld(Main.mainWorld), -31.5, 12, -7.5);
				Location sp4 = new Location(plugin.getServer().getWorld(Main.mainWorld), 8.5, 12, -2.5);
				Item item1 = sp1.getWorld().dropItem(sp1, new ItemStack(Material.EMERALD));
				item1.setVelocity(new Vector(0, 0.3, 0));
				Item item2 = sp1.getWorld().dropItem(sp2, new ItemStack(Material.EMERALD));
				item2.setVelocity(new Vector(0, 0.3, 0));
				Item item3 = sp1.getWorld().dropItem(sp3, new ItemStack(Material.EMERALD));
				item3.setVelocity(new Vector(0, 0.3, 0));
				Item item4 = sp1.getWorld().dropItem(sp4, new ItemStack(Material.EMERALD));
				item4.setVelocity(new Vector(0, 0.3, 0));
			}
		}, 1300l, 1200l);

		Bukkit.getServer().getWorld(Main.mainWorld).getPlayers().forEach(i -> {
			i.teleport(new Location(Bukkit.getWorld(Main.mainWorld), 0.5, 64, 0.5));
		});

		start();

		return false;

	}

	private static int startSch;

	public static void start() {
		Team.resetElok();
		
		startSch = plugin.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
			int remainingTime = 6;
			World mainWorld = Bukkit.getServer().getWorld(Main.mainWorld);

			@Override
			public void run() {

				mainWorld.getPlayers().forEach(i -> {
					i.sendTitle("§cStarting in §a" + (remainingTime - 1), "", 1, 18, 1);
				});
				remainingTime--;

				if (remainingTime == 0) {
					mainWorld.getPlayers().forEach(i -> {
						i.setGameMode(GameMode.SURVIVAL);
					});

					List<Player> playerList = mainWorld.getPlayers();
					@SuppressWarnings("unchecked")
					HashMap<TeamType, Location> availableLocs = (HashMap<TeamType, Location>) Main.spawnLocs.clone();
					
					while (playerList.size() > 0) {
						Random rand = new Random();
						Player randPlayer = playerList.get(rand.nextInt(playerList.size()));
						Location loc = availableLocs.get(TeamType.RED);
						switch (playerList.size()) {
						case 1:
							loc = availableLocs.get(TeamType.RED);
							availableLocs.remove(TeamType.RED);
							Team.addToTeam(TeamType.RED, randPlayer);
							break;
						case 2:
							loc = availableLocs.get(TeamType.BLUE);
							availableLocs.remove(TeamType.BLUE);
							Team.addToTeam(TeamType.BLUE, randPlayer);
							break;
						case 3:
							loc = availableLocs.get(TeamType.GREEN);
							availableLocs.remove(TeamType.GREEN);
							Team.addToTeam(TeamType.GREEN, randPlayer);
							break;
						case 4:
							loc = availableLocs.get(TeamType.YELLOW);
							availableLocs.remove(TeamType.YELLOW);
							Team.addToTeam(TeamType.YELLOW, randPlayer);
							break;
						}
						Bukkit.broadcastMessage(availableLocs.size() + ", Eredeti: " + Main.spawnLocs.size());

						Bukkit.broadcastMessage(randPlayer.getCustomName());
						randPlayer.teleport(loc);
						playerList.remove(randPlayer);
					}
					
					plugin.getServer().getScheduler().cancelTask(startSch);
					
					Main.megyAJatek = true;
				}

			}

		}, 0, 20l);
	}
}
