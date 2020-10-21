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
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Sheep;
import org.bukkit.entity.Villager;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.plugin.Plugin;

import me.hvmarci.bedwars.Main;
import me.hvmarci.bedwars.ItemDeclarations.ItemDeclarations;
import me.hvmarci.bedwars.ItemDeclarations.ItemType;

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
				
				LivingEntity shop = (Villager) loc.getWorld().spawnEntity(loc, EntityType.VILLAGER);
				if (args.length == 1) {
					try {
						shop.setRotation(Integer.parseInt(args[0]), 0);
					} catch (Exception e) {
						
					}
				}
				
				shop.setInvulnerable(true);
				shop.setAI(false);
				shop.setSilent(true);
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
				inv.addItem(new ItemStack(Material.DIAMOND_SWORD));
				inv.addItem(new ItemStack(Material.BOW));
				inv.addItem(new ItemStack(Material.COBBLESTONE, 3*64));
				inv.addItem(new ItemStack(Material.GOLDEN_APPLE, 3));
				inv.addItem(new ItemStack(Material.ENCHANTED_GOLDEN_APPLE, 1));
				inv.addItem(new ItemStack(Material.ARROW, 64));
				inv.addItem(new ItemStack(Material.COOKED_PORKCHOP, 64));
				//inv.addItem(idec.faKard());
				
				players.forEach(i -> {
					i.sendMessage("§a" + p.getName() + " §cDONÁTOLT§a magának egy " + ChatColor.MAGIC+ "banánt!!");
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
		} else if (cmd.getName().equals("allit")) {
			plugin.getServer().getScheduler().cancelTasks(plugin);
		} else if (cmd.getName().equals("thor")) {
			if (sender instanceof Player) {
				plugin.getServer().getOnlinePlayers().forEach(i->{
					i.sendMessage(sender.getName() + " Thor lett!");
				});
				
				((Player) sender).getInventory().addItem(idec.getItem(ItemType.VILLAMPALCA, false));
			}
		}

		return true;

	}
}
