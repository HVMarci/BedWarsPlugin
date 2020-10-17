package me.hvmarci.bedwars.CommandHandlers;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import me.hvmarci.bedwars.Main;

public class ArenaBlokkokTorlese implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Main.arenaPlacedBlocks.forEach(i -> {
			i.setType(Material.AIR);
		});
		
		Main.arenaPlacedBlocks.clear();
		
		return true;
	}
}
