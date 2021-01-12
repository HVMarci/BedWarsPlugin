package me.hvmarci.bedwars;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;
import org.bukkit.scoreboard.Team;

import me.hvmarci.bedwars.CommandHandlers.ArenaBlokkokTorlese;
import me.hvmarci.bedwars.CommandHandlers.CommandHandler;
import me.hvmarci.bedwars.CommandHandlers.Freeze;
import me.hvmarci.bedwars.CommandHandlers.UnFreeze;
import me.hvmarci.bedwars.CommandHandlers.Start.StartGame;
import me.hvmarci.bedwars.CommandHandlers.GameModeHandler;
import me.hvmarci.bedwars.CommandHandlers.Invensee;
import me.hvmarci.bedwars.CommandHandlers.KapaHandler;
import me.hvmarci.bedwars.CommandHandlers.TpToGame;
import me.hvmarci.bedwars.CommandHandlers.TpToPVPArena;
import me.hvmarci.bedwars.Listeners.BedBroke;
import me.hvmarci.bedwars.Listeners.BedWarsListeners;
import me.hvmarci.bedwars.Listeners.DeathListener;
import me.hvmarci.bedwars.Listeners.FrostOrNot;
import me.hvmarci.bedwars.Listeners.PVPArenaListeners;
import me.hvmarci.bedwars.Listeners.ShopListener;
import me.hvmarci.bedwars.Listeners.Stop;
import me.hvmarci.bedwars.hulyesegek.PattogATojas;
import me.hvmarci.bedwars.hulyesegek.SajatCucc;

public class Main extends JavaPlugin implements Listener {

	public static String pluginName = "BedWars";
	public static String buildWorld = "build";
	public static String mainWorld = "game";
	public static String pvpWorld = "pvp";
	public static ArrayList<String> frost = new ArrayList<String>();
	public static ArrayList<Block> arenaPlacedBlocks = new ArrayList<Block>();
	public static final HashMap<TeamType, Location> spawnLocs = new HashMap<TeamType, Location>();
	public static ScoreboardManager scbm = Bukkit.getScoreboardManager();
	public static Scoreboard scb = scbm.getMainScoreboard();

	@Override
	public void onEnable() {

		getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "A BedWarsPlugin sikeresen betöltött!");
		
		getServer().getPluginManager().registerEvents(new BedWarsListeners(), this);
		getServer().getPluginManager().registerEvents(new ShopListener(), this);
		getServer().getPluginManager().registerEvents(new FrostOrNot(), this);
		getServer().getPluginManager().registerEvents(new PVPArenaListeners(), this);
		getServer().getPluginManager().registerEvents(new BedBroke(), this);
		getServer().getPluginManager().registerEvents(new DeathListener(), this);
		//getServer().getPluginManager().registerEvents(new EggThrowEvent(), this);
		//getServer().getPluginManager().registerEvents(new PattogATojas(), this);
		//getServer().getPluginManager().registerEvents(new SajatCucc(), this);
		
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
		getCommand("game").setExecutor(new TpToGame());
		
		getConfig().options().copyDefaults(true);
		saveConfig();
		
		spawnLocs.put(TeamType.BLUE, new Location(this.getServer().getWorld(mainWorld), -28, 11, -69));
		spawnLocs.put(TeamType.RED, new Location(this.getServer().getWorld(mainWorld), -16, 11, 83));
		spawnLocs.put(TeamType.GREEN, new Location(this.getServer().getWorld(mainWorld), -87, 11, -6));
		spawnLocs.put(TeamType.YELLOW, new Location(this.getServer().getWorld(mainWorld), 90, 12, 12));
		
		Team redTeam = scb.registerNewTeam("redTeam");
		Team blueTeam = scb.registerNewTeam("blueTeam");
		Team greenTeam = scb.registerNewTeam("greenTeam");
		Team yellowTeam = scb.registerNewTeam("yellowTeam");
		
		redTeam.setColor(ChatColor.RED);
		blueTeam.setColor(ChatColor.BLUE);
		greenTeam.setColor(ChatColor.GREEN);
		yellowTeam.setColor(ChatColor.YELLOW);
		
		redTeam.setAllowFriendlyFire(false);
		blueTeam.setAllowFriendlyFire(false);
		greenTeam.setAllowFriendlyFire(false);
		yellowTeam.setAllowFriendlyFire(false);
	}

	@Override
	public void onDisable() {
		getServer().getConsoleSender().sendMessage("A BedWarsPlugin sikeresen leállt!");
		scb.getTeams().forEach(i->{
			i.unregister();
		});
	}

}
