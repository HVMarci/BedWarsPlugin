package me.hvmarci.bedwars.CommandHandlers;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import me.hvmarci.bedwars.Main;

public class UnFreeze implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (args.length == 1) {
			try {
				Main.frost.remove(Bukkit.getPlayer(args[0]).getName());
				return true;
			} catch (Exception e) {
				sender.sendMessage("§c/unfreeze ONLINEPlayer");
				return false;
			}
		} else {
			sender.sendMessage("§c/unfreeze Player");
			return false;
		}
		
	}

}
