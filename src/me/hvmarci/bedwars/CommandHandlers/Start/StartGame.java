package me.hvmarci.bedwars.CommandHandlers.Start;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Item;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.bukkit.util.Vector;

import me.hvmarci.bedwars.Main;

public class StartGame implements CommandExecutor {
	
	Plugin plugin = Bukkit.getPluginManager().getPlugin(Main.pluginName);
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		// vas
		plugin.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
			public void run() {
				Location sp1 = new Location(plugin.getServer().getWorld(Main.buildWorld), 1, 11, 85);
			  	sp1.getWorld().dropItem(sp1, new ItemStack(Material.IRON_INGOT));
			}
		}, 20l, 20l);
		
		// arany
		plugin.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
			public void run() {
				Location sp1 = new Location(plugin.getServer().getWorld(Main.buildWorld), 1, 11, 85);
			  	sp1.getWorld().dropItem(sp1, new ItemStack(Material.GOLD_INGOT));
			}
		}, 200l, 200l);
		
		// smaragd
		plugin.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
			public void run() {
				Location sp1 = new Location(plugin.getServer().getWorld(Main.buildWorld), 17.5, 12, 131.5);
			  	Item item = sp1.getWorld().dropItem(sp1, new ItemStack(Material.EMERALD));
			  	item.setVelocity(new Vector(0,0.3,0));
			}
		}, 100l, 100l);
		
		
		//Bukkit.getServer().getWorld(Main.mainWorld).;
		
		return false;
		
	}
}
