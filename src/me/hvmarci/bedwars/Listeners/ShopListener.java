package me.hvmarci.bedwars.Listeners;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.HumanEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import me.hvmarci.bedwars.ItemDeclarations;

public class ShopListener implements Listener {

	Inventory inv = Bukkit.createInventory(null, 5*9, "Shop");
	ItemDeclarations idec = new ItemDeclarations();
	
	@EventHandler
	public void onClickShop(PlayerInteractAtEntityEvent e) {
		System.out.println(e.getRightClicked().getType());
		if (e.getRightClicked().getType().equals(EntityType.VILLAGER)) {
			
			for(int i = 0; i<45;i++) {
				inv.clear(i);
			}
			
			inv.setItem(10, idec.gyapju());
			inv.setItem(11, idec.deszka());
			inv.setItem(12, idec.endKo());
			inv.setItem(13, idec.obszidian());
			inv.setItem(19, idec.koKard());
			inv.setItem(20, idec.vasKard());
			inv.setItem(21, idec.gyemantKard());
			inv.setItem(22, idec.netheritKard());
			inv.setItem(23, idec.netheritBalta());
			inv.setItem(28, idec.tolgyCsemete());
		
			e.getPlayer().openInventory(inv);
		}
	}
	
	
	
	@EventHandler
	public void onItemClick(InventoryClickEvent e) {
		
		HumanEntity p = e.getWhoClicked();
		
		if (e.getInventory().equals(inv)) {
			e.setCancelled(true);
			
			try {
				if (e.getCurrentItem().equals(idec.gyapju())) {
					
					if(p.getInventory().containsAtLeast(new ItemStack(Material.IRON_INGOT), 4)) {
						p.getInventory().addItem(new ItemStack(Material.RED_WOOL, 16));
						p.getInventory().removeItemAnySlot(new ItemStack(Material.IRON_INGOT, 4));
					} else {
						p.sendMessage(ChatColor.RED + "Nincs elég vasad!");
					}
					
				} else if (e.getCurrentItem().equals(idec.deszka())) {
					
					if(p.getInventory().containsAtLeast(new ItemStack(Material.GOLD_INGOT), 4)) {
						p.getInventory().addItem(new ItemStack(Material.OAK_PLANKS, 16));
						p.getInventory().removeItemAnySlot(new ItemStack(Material.GOLD_INGOT, 4));
					} else {
						p.sendMessage(ChatColor.RED + "Nincs elég aranyad!");
					}
					
				}  else if (e.getCurrentItem().equals(idec.endKo())) {
					
					if(p.getInventory().containsAtLeast(new ItemStack(Material.IRON_INGOT), 12)) {
						p.getInventory().addItem(new ItemStack(Material.END_STONE, 12));
						p.getInventory().removeItemAnySlot(new ItemStack(Material.IRON_INGOT, 12));
					} else {
						p.sendMessage(ChatColor.RED + "Nincs elég vasad!");
					}
					
				} else if (e.getCurrentItem().equals(idec.obszidian())) {
					
					if(p.getInventory().containsAtLeast(new ItemStack(Material.EMERALD), 4)) {
						p.getInventory().addItem(new ItemStack(Material.OBSIDIAN, 4));
						p.getInventory().removeItemAnySlot(new ItemStack(Material.EMERALD, 4));
					} else {
						p.sendMessage(ChatColor.RED + "Nincs elég smaragdod!");
					}
					
				} else if (e.getCurrentItem().equals(idec.koKard())) {
					
					if(p.getInventory().containsAtLeast(new ItemStack(Material.IRON_INGOT), 10)) {
						p.getInventory().addItem(new ItemStack(Material.STONE_SWORD, 1));
						p.getInventory().removeItemAnySlot(new ItemStack(Material.IRON_INGOT, 10));
					} else {
						p.sendMessage(ChatColor.RED + "Nincs elég vasad!");
					}
					
				} else if (e.getCurrentItem().equals(idec.vasKard())) {
					
					if(p.getInventory().containsAtLeast(new ItemStack(Material.GOLD_INGOT), 7)) {
						p.getInventory().addItem(new ItemStack(Material.IRON_SWORD, 1));
						p.getInventory().removeItemAnySlot(new ItemStack(Material.GOLD_INGOT, 7));
					} else {
						p.sendMessage(ChatColor.RED + "Nincs elég aranyad!");
					}
					
				} else if (e.getCurrentItem().equals(idec.gyemantKard())) {
					
					if (p.getInventory().containsAtLeast(new ItemStack(Material.EMERALD), 4)) {
						p.getInventory().addItem(new ItemStack(Material.DIAMOND_SWORD, 1));
						p.getInventory().removeItemAnySlot(new ItemStack(Material.EMERALD, 4));
					} else {
						p.sendMessage(ChatColor.RED + "Nincs elég smaragdod!");
					}
					
				} else if (e.getCurrentItem().equals(idec.netheritKard())) {
					
					if (p.getInventory().containsAtLeast(new ItemStack(Material.EMERALD), 6)) {
						p.getInventory().addItem(new ItemStack(Material.NETHERITE_SWORD, 1));
						p.getInventory().removeItemAnySlot(new ItemStack(Material.EMERALD, 6));
					} else {
						p.sendMessage(ChatColor.RED + "Nincs elég smaragdod!");
					}
					
				} else if (e.getCurrentItem().equals(idec.netheritBalta())) {
					
					if (p.getInventory().containsAtLeast(new ItemStack(Material.EMERALD), 11)) {
						p.getInventory().addItem(new ItemStack(idec.netheritBalta()));
						p.getInventory().removeItemAnySlot(new ItemStack(Material.EMERALD, 11));
					} else {
						p.sendMessage(ChatColor.RED + "Nincs elég smaragdod!");
					}
					
				} else if (e.getCurrentItem().equals(idec.tolgyCsemete())) {
					
					if(p.getInventory().containsAtLeast(new ItemStack(Material.GOLD_INGOT), 5)) {
						p.getInventory().addItem(new ItemStack(Material.OAK_SAPLING, 2));
						p.getInventory().addItem(new ItemStack(Material.DIRT, 2));
						p.getInventory().removeItemAnySlot(new ItemStack(Material.GOLD_INGOT, 5));
					} else {
						p.sendMessage(ChatColor.RED + "Nincs elég aranyad!");
					}
					
				}
			} catch (Exception ex) {
				
			}
		}
	}
}
