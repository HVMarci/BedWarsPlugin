package me.hvmarci.bedwars.Listeners;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import me.hvmarci.bedwars.Main;

public class Stop implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Main.arenaPlacedBlocks.forEach(i->{
			i.setType(Material.AIR);
		});
		Main.arenaPlacedBlocks.clear();
		Bukkit.shutdown();
		
		return true;
	}
}
