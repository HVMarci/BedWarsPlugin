package me.hvmarci.bedwars;

import org.bukkit.ChatColor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import me.hvmarci.bedwars.CommandHandlers.CommandHandler;
import me.hvmarci.bedwars.CommandHandlers.GameModeHandler;
import me.hvmarci.bedwars.CommandHandlers.Invensee;
import me.hvmarci.bedwars.CommandHandlers.KapaHandler;
import me.hvmarci.bedwars.CommandHandlers.StartGame;
import me.hvmarci.bedwars.Listeners.BedWarsListeners;
import me.hvmarci.bedwars.Listeners.ShopListener;

public class Main extends JavaPlugin implements Listener {

	public static String pluginName = "BedWars";
	public static String buildWorld = "build";
	public static String mainWorld = "map";
	
	@Override
	public void onEnable() {

		getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "A BedWarsPlugin sikeresen betöltött!");
		
		getServer().getPluginManager().registerEvents(new BedWarsListeners(), this);
		getServer().getPluginManager().registerEvents(new ShopListener(), this);
		
		getCommand("gamemode").setExecutor(new GameModeHandler());
		getCommand("spawnhuman").setExecutor(new CommandHandler());
		getCommand("opstuff").setExecutor(new CommandHandler());
		getCommand("birka").setExecutor(new CommandHandler());
		getCommand("start").setExecutor(new StartGame());
		getCommand("allit").setExecutor(new CommandHandler());
		getCommand("thor").setExecutor(new CommandHandler());
		getCommand("kapa").setExecutor(new KapaHandler());
		getCommand("invensee").setExecutor(new Invensee());
		
		getConfig().options().copyDefaults(true);
		saveConfig();
		
		
	}

	@Override
	public void onDisable() {
		getServer().getConsoleSender().sendMessage("A BedWarsPlugin sikeresen leállt!");
	}

	
	

}
