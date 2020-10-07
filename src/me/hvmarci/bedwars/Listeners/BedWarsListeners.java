package me.hvmarci.bedwars.Listeners;

import java.util.Collection;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.TreeType;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockExplodeEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.entity.EntityPotionEffectEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerGameModeChangeEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.Plugin;

import me.hvmarci.bedwars.ItemDeclarations;

public class BedWarsListeners implements Listener {
	
	Plugin plugin = Bukkit.getPluginManager().getPlugin("BedWars");
	ItemDeclarations idec = new ItemDeclarations();
	
	@EventHandler
	public void onVillamPalca(PlayerInteractEvent e) {
		try {
			if (e.getItem().equals(idec.villamPalca()) && (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK)) {
				Block b = e.getPlayer().getTargetBlock(50);
				if (b != null) {
					Location loc = b.getLocation();
					loc.getWorld().strikeLightning(loc);
				}
			}
		} catch (Exception ex) {
			
		}
	}
	
	
	@EventHandler
	public void onGameModeChanged(PlayerGameModeChangeEvent e) {

		Collection<? extends Player> players = e.getPlayer().getServer().getOnlinePlayers();
		String name = e.getPlayer().getName();

		players.forEach(i -> {
			String gameMode = new String();
			if (e.getNewGameMode() == GameMode.ADVENTURE) {
				gameMode = "Kaland mód";
			} else if (e.getNewGameMode() == GameMode.CREATIVE) {
				gameMode = "Kreatív";
			} else if (e.getNewGameMode() == GameMode.SPECTATOR) {
				gameMode = "Szemlélõ";
			} else if (e.getNewGameMode() == GameMode.SURVIVAL) {
				gameMode = "Túlélõ";
			}

			i.sendMessage(ChatColor.GOLD + name + ChatColor.BLUE + " játékmódja mostantól " + gameMode + ".");
		});

	}

	@EventHandler
	public void onJoin(PlayerJoinEvent e) {

		Collection<? extends Player> players = e.getPlayer().getServer().getOnlinePlayers();
		Player player = e.getPlayer();

		players.forEach(i -> {
			i.sendMessage(ChatColor.GOLD + player.getName() + ChatColor.BLUE + " felcsatlakozott a szerverre!");
		});
		
		e.setJoinMessage(null);

	}

	@EventHandler
	public void onLeave(PlayerQuitEvent e) {

		Collection<? extends Player> players = e.getPlayer().getServer().getOnlinePlayers();
		Player player = e.getPlayer();

		players.forEach(i -> {
			i.sendMessage(ChatColor.GOLD + player.getName() + ChatColor.BLUE + " elhagyta a szervert.");
		});
		
		e.setQuitMessage(null);

	}
	
	@EventHandler
	public void onChat(AsyncPlayerChatEvent e) {
		
		Collection<? extends Player> players = e.getPlayer().getServer().getOnlinePlayers();
		Player player = e.getPlayer();
		String message = e.getMessage();
		
		players.forEach(i -> {
			i.sendMessage(ChatColor.RED + player.getDisplayName() /*+ ChatColor.WHITE + " (" +player.getEquipment().getItemInMainHand().getType() + " "+player.getEquipment().getItemInMainHand().getEnchantments()+"-t fog a kezében)"*/+ ChatColor.GOLD + "> " + ChatColor.BLUE + message);
		});
		
		e.setCancelled(true);
	}
	
	@EventHandler
	public void onPlace(BlockPlaceEvent e) {
		Block b = e.getBlock();
		//Player p = e.getPlayer();
		Location loc = b.getLocation();
		//ItemStack itemStack = p.getEquipment().getItemInMainHand();
		
		if(b.getType().equals(Material.OAK_SAPLING)) {
			
			/*if (p.getGameMode().equals(GameMode.SURVIVAL)) {
				itemStack.setAmount(itemStack.getAmount() -1);
				p.getEquipment().setItemInMainHand(itemStack);
			}*/
			
			loc.getBlock().setType(Material.AIR);
			loc.getWorld().generateTree(loc, TreeType.TREE);
			
		}
	}
	
	@EventHandler
	public void onBreak(BlockBreakEvent e) {
		Block b = e.getBlock();
		//Player p = e.getPlayer();
		if ((b.getType().equals(Material.IRON_BLOCK) || e.getBlock().getType().equals(Material.DIAMOND_BLOCK) || e.getBlock().getType().equals(Material.EMERALD_BLOCK)) && !plugin.getConfig().getBoolean("can_break_iron_block")) {
			e.setCancelled(true);
		}
	}
	
	@EventHandler
	public void onEntityExplode(EntityExplodeEvent e) {
		
		if (!plugin.getConfig().getBoolean("do_tnt_explode")) {
			e.setCancelled(true);			
		}
	}
	
	
	@EventHandler
	public void onRespawnAnchorInteract(PlayerInteractEvent e) {
		if (e.getClickedBlock() != null) {
			Block b = e.getClickedBlock();
			if (b.getType().equals(Material.RESPAWN_ANCHOR)) {
				e.setCancelled(true);
			}
		}
		
	}
	
	@EventHandler
	public void onBlockExplode(BlockExplodeEvent e) {
		e.setCancelled(true);
	}
	
	@EventHandler
	public void onGettingInvisible(EntityPotionEffectEvent e) {
		if (!plugin.getConfig().getBoolean("can_use_potions")) {
			e.setCancelled(true);
		}
	}
}
