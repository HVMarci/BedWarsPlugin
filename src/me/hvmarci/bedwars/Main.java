package me.hvmarci.bedwars;

import java.util.ArrayList;
import org.bukkit.ChatColor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import me.hvmarci.bedwars.CommandHandlers.CommandHandler;
import me.hvmarci.bedwars.CommandHandlers.Freeze;
import me.hvmarci.bedwars.CommandHandlers.UnFreeze;
import me.hvmarci.bedwars.CommandHandlers.GameModeHandler;
import me.hvmarci.bedwars.CommandHandlers.Invensee;
import me.hvmarci.bedwars.CommandHandlers.KapaHandler;
import me.hvmarci.bedwars.CommandHandlers.StartGame;
import me.hvmarci.bedwars.Listeners.BedWarsListeners;
import me.hvmarci.bedwars.Listeners.FrostOrNot;
import me.hvmarci.bedwars.Listeners.ShopListener;

public class Main extends JavaPlugin implements Listener {

	public static String pluginName = "BedWars";
	public static String buildWorld = "build";
	public static String mainWorld = "map";
	public static ArrayList<String> frost = new ArrayList<String>();
	
	@Override
	public void onEnable() {

		getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "A BedWarsPlugin sikeresen betöltött!");
		
		getServer().getPluginManager().registerEvents(new BedWarsListeners(), this);
		getServer().getPluginManager().registerEvents(new ShopListener(), this);
		getServer().getPluginManager().registerEvents(new FrostOrNot(), this);
		
		getCommand("gamemode").setExecutor(new GameModeHandler());
		getCommand("spawnhuman").setExecutor(new CommandHandler());
		getCommand("opstuff").setExecutor(new CommandHandler());
		getCommand("birka").setExecutor(new CommandHandler());
		getCommand("start").setExecutor(new StartGame());
		getCommand("allit").setExecutor(new CommandHandler());
		getCommand("thor").setExecutor(new CommandHandler());
		getCommand("kapa").setExecutor(new KapaHandler());
		getCommand("invensee").setExecutor(new Invensee());
		getCommand("freeze").setExecutor(new Freeze());
		getCommand("unfreeze").setExecutor(new UnFreeze());
		
		getConfig().options().copyDefaults(true);
		saveConfig();
		
		
	}

	@Override
	public void onDisable() {
		getServer().getConsoleSender().sendMessage("A BedWarsPlugin sikeresen leállt!");
	}

	
	

}
