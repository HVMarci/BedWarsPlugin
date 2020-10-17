package me.hvmarci.bedwars;

import java.util.ArrayList;
import org.bukkit.ChatColor;
import org.bukkit.block.Block;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import me.hvmarci.bedwars.CommandHandlers.ArenaBlokkokTorlese;
import me.hvmarci.bedwars.CommandHandlers.CommandHandler;
import me.hvmarci.bedwars.CommandHandlers.Freeze;
import me.hvmarci.bedwars.CommandHandlers.UnFreeze;
import me.hvmarci.bedwars.CommandHandlers.Start.StartGame;
import me.hvmarci.bedwars.CommandHandlers.GameModeHandler;
import me.hvmarci.bedwars.CommandHandlers.Invensee;
import me.hvmarci.bedwars.CommandHandlers.KapaHandler;
import me.hvmarci.bedwars.CommandHandlers.TpToPVPArena;
import me.hvmarci.bedwars.Listeners.BedWarsListeners;
import me.hvmarci.bedwars.Listeners.FrostOrNot;
import me.hvmarci.bedwars.Listeners.PVPArenaListeners;
import me.hvmarci.bedwars.Listeners.ShopListener;
import me.hvmarci.bedwars.Listeners.Stop;

public class Main extends JavaPlugin implements Listener {

	public static String pluginName = "BedWars";
	public static String buildWorld = "build";
	public static String mainWorld = "map";
	public static String pvpWorld = "pvp";
	public static ArrayList<String> frost = new ArrayList<String>();
	public static ArrayList<Block> arenaPlacedBlocks = new ArrayList<Block>();
	
	@Override
	public void onEnable() {

		getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "A BedWarsPlugin sikeresen betöltött!");
		
		getServer().getPluginManager().registerEvents(new BedWarsListeners(), this);
		getServer().getPluginManager().registerEvents(new ShopListener(), this);
		getServer().getPluginManager().registerEvents(new FrostOrNot(), this);
		getServer().getPluginManager().registerEvents(new PVPArenaListeners(), this);
		
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
		getCommand("pvp").setExecutor(new TpToPVPArena());
		getCommand("arenaurites").setExecutor(new ArenaBlokkokTorlese());
		getCommand("stop").setExecutor(new Stop());
		
		getConfig().options().copyDefaults(true);
		saveConfig();
		
		
	}

	@Override
	public void onDisable() {
		getServer().getConsoleSender().sendMessage("A BedWarsPlugin sikeresen leállt!");
	}

	
	

}
