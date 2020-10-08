package me.hvmarci.bedwars.CommandHandlers;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class Invensee implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if (args.length == 1) {
			
			if (sender instanceof Player) {
				Player p = (Player) sender;
				try {
					Player p2 = Bukkit.getPlayer(args[0]);
					Inventory inv = p2.getInventory();
					p.openInventory(inv);
					return true;
				} catch (Exception e) {
					p.sendMessage("§cOnline játékost adj meg!");
					return false;
				}
				
				
			} else {
				sender.sendMessage("§cPlayer command!");
				return false;
			}
			
		} else {
			sender.sendMessage("§c/invensee [Player]");
			return false;
		}
		
		
		
	}

}
