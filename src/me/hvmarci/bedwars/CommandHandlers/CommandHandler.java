package me.hvmarci.bedwars.CommandHandlers;

import java.util.Collection;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.DyeColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Item;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Sheep;
import org.bukkit.entity.Zombie;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.plugin.Plugin;
import org.bukkit.util.Vector;

import me.hvmarci.bedwars.ItemDeclarations;
import me.hvmarci.bedwars.Main;

public class CommandHandler implements CommandExecutor {
	
	Plugin plugin = Bukkit.getPluginManager().getPlugin(Main.pluginName);
	ItemDeclarations idec = new ItemDeclarations();
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if (cmd.getName().equals("gamemode")) {

			if (sender instanceof ConsoleCommandSender) {
				sender.sendMessage("§cTe egy konzol vagy!");
			} else if(args.length == 1) {
				Player p = (Player) sender;

				if (args[0].equalsIgnoreCase("0") || args[0].equalsIgnoreCase("survival")) {
					p.setGameMode(GameMode.SURVIVAL);
				} else if (args[0].equalsIgnoreCase("1") || args[0].equalsIgnoreCase("creative")) {
					p.setGameMode(GameMode.CREATIVE);
				} else if (args[0].equalsIgnoreCase("2") || args[0].equalsIgnoreCase("adventure")) {
					p.setGameMode(GameMode.ADVENTURE);
				} else if (args[0].equalsIgnoreCase("3") || args[0].equalsIgnoreCase("spectator")) {
					p.setGameMode(GameMode.SPECTATOR);
				} else {
					p.sendMessage("§c/gamemode 0|1|2|3");
				}
			} else if(args.length == 2) {
				
				if (plugin.getServer().getPlayer(args[1]) != null) {
					Player p = plugin.getServer().getPlayer(args[1]);
					if (!p.equals(null)) {
						if (args[0].equalsIgnoreCase("0") || args[0].equalsIgnoreCase("survival")) {
							p.setGameMode(GameMode.SURVIVAL);
						} else if (args[0].equalsIgnoreCase("1") || args[0].equalsIgnoreCase("creative")) {
							p.setGameMode(GameMode.CREATIVE);
						} else if (args[0].equalsIgnoreCase("2") || args[0].equalsIgnoreCase("adventure")) {
							p.setGameMode(GameMode.ADVENTURE);
						} else if (args[0].equalsIgnoreCase("3") || args[0].equalsIgnoreCase("spectator")) {
							p.setGameMode(GameMode.SPECTATOR);
						} else {
							p.sendMessage("§c/gamemode 0|1|2|3|survival|creative|adventure|spectator");
						}
					}
				} else {
					sender.sendMessage("§cVálassz egy online játékost!");
				}

			} else {
				sender.sendMessage("§c/gamemode 0|1|2|3");
			}
		} else if (cmd.getName().equals("spawnhuman")) {
			if (sender instanceof Player) {
				Player p = (Player) sender;
				Location loc = new Location(p.getLocation().getWorld(), p.getLocation().getX(), p.getLocation().getY(), p.getLocation().getZ());
				
				LivingEntity shop = (Zombie) loc.getWorld().spawnEntity(loc, EntityType.ZOMBIE);
				shop.setInvulnerable(true);
				shop.setAI(false);
				shop.setSilent(false);
				shop.setCustomName(ChatColor.AQUA+"Boltos");
				shop.setCustomNameVisible(true);
				p.sendMessage("§aBoltos megidézve!");
				
			} else {
				sender.sendMessage("§cKonzol vagy!");
			}
			
		} else if (cmd.getName().equals("opstuff")) {
			if(sender instanceof Player) {
				Player p = (Player) sender;
				PlayerInventory inv = p.getInventory();
				Collection<? extends Player> players = plugin.getServer().getOnlinePlayers();
				
				inv.setBoots(new ItemStack(Material.DIAMOND_BOOTS));
				inv.setLeggings(new ItemStack(Material.DIAMOND_LEGGINGS));
				inv.setChestplate(new ItemStack(Material.DIAMOND_CHESTPLATE));
				inv.setHelmet(new ItemStack(Material.DIAMOND_HELMET));
				inv.addItem(idec.faKard());
				
				players.forEach(i -> {
					i.sendMessage("§a" + p.getName() + " §cDONÁTOLT §a magának egy " + ChatColor.MAGIC+ "banánt!!");
				});
				
			} else {
				sender.sendMessage("khmm");
			}
		} else if (cmd.getName().equals("birka")) {
			if (sender instanceof Player) {
				Player p = (Player) sender;
				Location loc = p.getLocation();
				
				for (int i = 0; i<100; i++) {
					Sheep sheep = (Sheep) loc.getWorld().spawnEntity(loc, EntityType.SHEEP);
					
					sheep.setColor(DyeColor.MAGENTA);
				}
			}
		} else if (cmd.getName().equals("start")) {
			
			
			plugin.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
				public void run() {
					Location sp1 = new Location(plugin.getServer().getWorld("world"), 1, 11, 85);
				  	sp1.getWorld().dropItem(sp1, new ItemStack(Material.IRON_INGOT));
				}
			}, 20l, 20l);
			
			plugin.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
				public void run() {
					Location sp1 = new Location(plugin.getServer().getWorld("world"), 1, 11, 85);
				  	sp1.getWorld().dropItem(sp1, new ItemStack(Material.GOLD_INGOT));
				}
			}, 200l, 200l);
			
			plugin.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
				public void run() {
					Location sp1 = new Location(plugin.getServer().getWorld("world"), 17.5, 12, 131.5);
				  	Item item = sp1.getWorld().dropItem(sp1, new ItemStack(Material.EMERALD));
				  	item.setVelocity(new Vector(0,0.3,0));
				}
			}, 100l, 100l);
			
		} else if (cmd.getName().equals("allit")) {
			plugin.getServer().getScheduler().cancelTasks(plugin);
		} else if (cmd.getName().equals("thor")) {
			if (sender instanceof Player) {
				plugin.getServer().getOnlinePlayers().forEach(i->{
					i.sendMessage(sender.getName() + " Thor lett!");
				});
				
				((Player) sender).getInventory().addItem(idec.villamPalca());
			}
		}

		return true;

	}
}
