package me.hvmarci.bedwars;

import org.bukkit.ChatColor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import me.hvmarci.bedwars.CommandHandlers.CommandHandler;
import me.hvmarci.bedwars.Listeners.BedWarsListeners;
import me.hvmarci.bedwars.Listeners.ShopListener;

public class Main extends JavaPlugin implements Listener {

	public static String pluginName = "BedWars";
	
	@Override
	public void onEnable() {

		getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "A BPE sikeresen betöltött!");
		
		getServer().getPluginManager().registerEvents(new BedWarsListeners(), this);
		getServer().getPluginManager().registerEvents(new ShopListener(), this);
		
		getCommand("gamemode").setExecutor(new CommandHandler());
		getCommand("spawnhuman").setExecutor(new CommandHandler());
		getCommand("opstuff").setExecutor(new CommandHandler());
		getCommand("birka").setExecutor(new CommandHandler());
		getCommand("start").setExecutor(new CommandHandler());
		getCommand("allit").setExecutor(new CommandHandler());
		getCommand("thor").setExecutor(new CommandHandler());
		
		getConfig().options().copyDefaults(true);
		saveConfig();
		
		
	}

	@Override
	public void onDisable() {
		getServer().getConsoleSender().sendMessage("A BPE sikeresen leállt!");
	}

	
	

}
