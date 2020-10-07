package me.hvmarci.bedwars.CommandHandlers;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import me.hvmarci.bedwars.Main;

public class GameModeHandler implements CommandExecutor {
	
	Plugin plugin = Bukkit.getPluginManager().getPlugin(Main.pluginName);
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof ConsoleCommandSender) {
			sender.sendMessage("§cEz egy játékos parancs!");
			return false;
		} else if(args.length == 1) {
			Player p = (Player) sender;

			if (args[0].equalsIgnoreCase("0") || args[0].equalsIgnoreCase("survival") || args[0].equalsIgnoreCase("s")) {
				p.setGameMode(GameMode.SURVIVAL);
				return true;
			} else if (args[0].equalsIgnoreCase("1") || args[0].equalsIgnoreCase("creative") || args[0].equalsIgnoreCase("c")) {
				p.setGameMode(GameMode.CREATIVE);
				return true;
			} else if (args[0].equalsIgnoreCase("2") || args[0].equalsIgnoreCase("adventure")) {
				p.setGameMode(GameMode.ADVENTURE);
				return true;
			} else if (args[0].equalsIgnoreCase("3") || args[0].equalsIgnoreCase("spectator")) {
				p.setGameMode(GameMode.SPECTATOR);
				return true;
			} else {
				p.sendMessage("§c/gamemode (0|1|2|3|survival|creative|adventure|spectator|s|c) [Player]");
				return false;
			}
		} else if(args.length == 2) {
			
			if (plugin.getServer().getPlayer(args[1]) != null) {
				Player p = plugin.getServer().getPlayer(args[1]);
				if (!p.equals(null)) {
					if (args[0].equalsIgnoreCase("0") || args[0].equalsIgnoreCase("survival") || args[0].equalsIgnoreCase("s")) {
						p.setGameMode(GameMode.SURVIVAL);
						return true;
					} else if (args[0].equalsIgnoreCase("1") || args[0].equalsIgnoreCase("creative") || args[0].equalsIgnoreCase("c")) {
						p.setGameMode(GameMode.CREATIVE);
						return true;
					} else if (args[0].equalsIgnoreCase("2") || args[0].equalsIgnoreCase("adventure")) {
						p.setGameMode(GameMode.ADVENTURE);
						return true;
					} else if (args[0].equalsIgnoreCase("3") || args[0].equalsIgnoreCase("spectator")) {
						p.setGameMode(GameMode.SPECTATOR);
						return true;
					} else {
						p.sendMessage("§c/gamemode (0|1|2|3|survival|creative|adventure|spectator|s|c) [Player]");
						return false;
					}
				} else {
					sender.sendMessage("§cVálassz egy online játékost!");
					return false;
				}
			} else {
				sender.sendMessage("§cVálassz egy online játékost!");
				return false;
			}

		} else {
			sender.sendMessage("§c/gamemode (0|1|2|3|survival|creative|adventure|spectator|s|c) [Player]");
			return false;
		}
	}
}
