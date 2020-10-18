package me.hvmarci.bedwars.CommandHandlers.Start;

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

public class StartGame implements CommandExecutor {
	
	static Plugin plugin = Bukkit.getPluginManager().getPlugin(Main.pluginName);
	
	
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		plugin.getServer().getWorld(Main.mainWorld).getPlayers().forEach(i->{
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
		}, 20l, 20l);
		
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
		}, 200l, 200l);
		
		// smaragd
		plugin.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
			public void run() {
				Location sp1 = new Location(plugin.getServer().getWorld(Main.mainWorld), 5.5,12,23.5);
				Location sp2 = new Location(plugin.getServer().getWorld(Main.mainWorld), -24.5,12,29.5);
				Location sp3 = new Location(plugin.getServer().getWorld(Main.mainWorld), -31.5,12,-7.5);
				Location sp4 = new Location(plugin.getServer().getWorld(Main.mainWorld), 8.5, 12, -2.5);
			  	Item item1 = sp1.getWorld().dropItem(sp1, new ItemStack(Material.EMERALD));
			  	item1.setVelocity(new Vector(0,0.3,0));
			  	Item item2 = sp1.getWorld().dropItem(sp2, new ItemStack(Material.EMERALD));
			  	item2.setVelocity(new Vector(0,0.3,0));
			  	Item item3 = sp1.getWorld().dropItem(sp3, new ItemStack(Material.EMERALD));
			  	item3.setVelocity(new Vector(0,0.3,0));
			  	Item item4 = sp1.getWorld().dropItem(sp4, new ItemStack(Material.EMERALD));
			  	item4.setVelocity(new Vector(0,0.3,0));
			}
		}, 100l, 100l);
		
		
		Bukkit.getServer().getWorld(Main.mainWorld).getPlayers().forEach(i->{
			i.teleport(new Location(Bukkit.getWorld(Main.mainWorld), 0.5, 64, 0.5));
		});
		
		start();
		
		return false;
		
		
		
	}

	static int startSch;
	public static void start() {
		startSch = plugin.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
			int remainingTime = 5;
			World mainWorld = Bukkit.getServer().getWorld(Main.mainWorld);
			@Override
			public void run() {
				
				mainWorld.getPlayers().forEach(i->{
					i.sendTitle("Starting in " + remainingTime, "", 1, 18, 1);
				});
				remainingTime--;
				
				if (remainingTime == 0) {
					mainWorld.getPlayers().forEach(i->{
						i.setGameMode(GameMode.SURVIVAL);
					});
					
					List<Player> playerList = mainWorld.getPlayers();
					do {
						Random rand = new Random();
				    	Player randPlayer = playerList.get(rand.nextInt(playerList.size()));
				    	Location randLoc = Main.spawnLocs.get(rand.nextInt(Main.spawnLocs.size()));
				    	Main.spawnLocs.remove(randLoc);
				    	randPlayer.teleport(randLoc);
				    	playerList.remove(randPlayer);
					} while (playerList.size() > 0);
				    
				    
					plugin.getServer().getScheduler().cancelTask(startSch);
				}
				
			}
			
		}, 0, 20l);
	}
}
	

