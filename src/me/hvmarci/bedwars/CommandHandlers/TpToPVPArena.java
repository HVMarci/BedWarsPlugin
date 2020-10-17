package me.hvmarci.bedwars.CommandHandlers;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.hvmarci.bedwars.Main;

public class TpToPVPArena implements CommandExecutor {
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player) {
			Player p = (Player) sender;
			World w = Bukkit.getServer().getWorld(Main.pvpWorld);
			Location loc = p.getLocation().set(0.5, 64, 0.5);
			
			loc.setWorld(w);
			
			p.teleport(loc);
			Bukkit.broadcastMessage(ChatColor.GOLD + p.getName() + "§b felcsatlakozott a PVP szerverre!");
			return true;
		} else {
			sender.sendMessage("§cJátékos parancs!");
			return false;
		}
	}
}
