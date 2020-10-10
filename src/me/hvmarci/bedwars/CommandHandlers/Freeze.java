package me.hvmarci.bedwars.CommandHandlers;

import org.bukkit.Bukkit;
//import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
//import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

import me.hvmarci.bedwars.Main;

public class Freeze implements CommandExecutor {
	
	Plugin plugin = Bukkit.getPluginManager().getPlugin(Main.pluginName);
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (args.length == 1) {
			try {
				Main.frost.add(Bukkit.getPlayer(args[0]).getName());
				new BukkitRunnable() {
			        
		            @Override
		            public void run() {
		                // What you want to schedule goes here
		                
		                Main.frost.remove(Bukkit.getPlayer(args[0]).getName());
		                
		            }
		            
		        }.runTaskLater(plugin, 60);
				
				return true;
			} catch (Exception e) {
				sender.sendMessage("§c/freeze ONLINEPlayer");
				return false;
			}
		} else {
			sender.sendMessage("§c/freeze Player");
			return false;
		}
		
	}

}
