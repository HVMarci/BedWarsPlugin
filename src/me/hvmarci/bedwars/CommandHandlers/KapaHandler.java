package me.hvmarci.bedwars.CommandHandlers;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class KapaHandler implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player) {
			Player p = (Player) sender;
			if (args.length == 0) {
				ItemStack kapa = new ItemStack(Material.DIAMOND_HOE);
				ItemMeta im = kapa.getItemMeta();
				im.addEnchant(Enchantment.DAMAGE_ALL, 30, true);
				kapa.setItemMeta(im);
				p.getInventory().addItem(kapa);
				p.sendMessage("§1Kaptál kapát!");
				return true;
			} else if (args.length == 1) {
				try {
					ItemStack kapa = new ItemStack(Material.DIAMOND_HOE);
					ItemMeta im = kapa.getItemMeta();
					
					im.addEnchant(Enchantment.DAMAGE_ALL, Integer.parseInt(args[0]), true);
					kapa.setItemMeta(im);
					p.getInventory().addItem(kapa);
					p.sendMessage("§1Kaptál kapát!");
					return true;
				} catch(Exception e) {
					p.sendMessage("§cSzámot adj meg!");
					return false;
				}
			} else {
				return false;
			}
		} else {
			sender.sendMessage("§cJátékos parancs!");
			return false;
		}
	}
	
}
