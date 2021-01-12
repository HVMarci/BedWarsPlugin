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

import me.hvmarci.bedwars.ItemDeclarations.ItemDeclarations;
import me.hvmarci.bedwars.ItemDeclarations.ItemType;

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
			
			inv.setItem(10, idec.getItem(ItemType.GYAPJU, true));
			inv.setItem(11, idec.getItem(ItemType.DESZKA, true));
			inv.setItem(12, idec.getItem(ItemType.ENDKO, true));
			inv.setItem(13, idec.getItem(ItemType.OBSZIDIAN, true));
			inv.setItem(19, idec.getItem(ItemType.KOKARD, true));
			inv.setItem(20, idec.getItem(ItemType.VASKARD, true));
			inv.setItem(21, idec.getItem(ItemType.GYEMANTKARD, true));
			inv.setItem(22, idec.getItem(ItemType.NETHERITKARD, true));
			inv.setItem(23, idec.getItem(ItemType.NETHERITFEJSZE, true));
			inv.setItem(28, idec.getItem(ItemType.TOLGYCSEMETE, true));
			inv.setItem(29, idec.getItem(ItemType.TOJAS, true));
		
			e.getPlayer().openInventory(inv);
		}
	}
	
	
	
	@EventHandler
	public void onItemClick(InventoryClickEvent e) {
		
		HumanEntity p = e.getWhoClicked();
		
		if (e.getInventory().equals(inv)) {
			e.setCancelled(true);
			
			try {
				if (e.getCurrentItem().equals(idec.getItem(ItemType.GYAPJU, true))) {
					
					if(p.getInventory().containsAtLeast(new ItemStack(Material.IRON_INGOT), 4)) {
						p.getInventory().addItem(idec.getItem(ItemType.GYAPJU, false));
						p.getInventory().removeItemAnySlot(new ItemStack(Material.IRON_INGOT, 4));
					} else {
						p.sendMessage(ChatColor.RED + "Nincs elég vasad!");
					}
					
				} else if (e.getCurrentItem().equals(idec.getItem(ItemType.DESZKA, true))) {
					
					if(p.getInventory().containsAtLeast(new ItemStack(Material.GOLD_INGOT), 4)) {
						p.getInventory().addItem(idec.getItem(ItemType.DESZKA, false));
						p.getInventory().removeItemAnySlot(new ItemStack(Material.GOLD_INGOT, 4));
					} else {
						p.sendMessage(ChatColor.RED + "Nincs elég aranyad!");
					}
					
				}  else if (e.getCurrentItem().equals(idec.getItem(ItemType.ENDKO, true))) {
					
					if(p.getInventory().containsAtLeast(new ItemStack(Material.IRON_INGOT), 12)) {
						p.getInventory().addItem(idec.getItem(ItemType.ENDKO, false));
						p.getInventory().removeItemAnySlot(new ItemStack(Material.IRON_INGOT, 12));
					} else {
						p.sendMessage(ChatColor.RED + "Nincs elég vasad!");
					}
					
				} else if (e.getCurrentItem().equals(idec.getItem(ItemType.OBSZIDIAN, true))) {
					
					if(p.getInventory().containsAtLeast(new ItemStack(Material.EMERALD), 4)) {
						p.getInventory().addItem(idec.getItem(ItemType.OBSZIDIAN, false));
						p.getInventory().removeItemAnySlot(new ItemStack(Material.EMERALD, 4));
					} else {
						p.sendMessage(ChatColor.RED + "Nincs elég smaragdod!");
					}
					
				} else if (e.getCurrentItem().equals(idec.getItem(ItemType.KOKARD, true))) {
					
					if(p.getInventory().containsAtLeast(new ItemStack(Material.IRON_INGOT), 10)) {
						p.getInventory().addItem(idec.getItem(ItemType.KOKARD, false));
						p.getInventory().removeItemAnySlot(new ItemStack(Material.IRON_INGOT, 10));
					} else {
						p.sendMessage(ChatColor.RED + "Nincs elég vasad!");
					}
					
				} else if (e.getCurrentItem().equals(idec.getItem(ItemType.VASKARD, true))) {
					
					if(p.getInventory().containsAtLeast(new ItemStack(Material.GOLD_INGOT), 7)) {
						p.getInventory().addItem(idec.getItem(ItemType.VASKARD, false));
						p.getInventory().removeItemAnySlot(new ItemStack(Material.GOLD_INGOT, 7));
					} else {
						p.sendMessage(ChatColor.RED + "Nincs elég aranyad!");
					}
					
				} else if (e.getCurrentItem().equals(idec.getItem(ItemType.GYEMANTKARD, true))) {
					
					if (p.getInventory().containsAtLeast(new ItemStack(Material.EMERALD), 4)) {
						p.getInventory().addItem(idec.getItem(ItemType.GYEMANTKARD, false));
						p.getInventory().removeItemAnySlot(new ItemStack(Material.EMERALD, 4));
					} else {
						p.sendMessage(ChatColor.RED + "Nincs elég smaragdod!");
					}
					
				} else if (e.getCurrentItem().equals(idec.getItem(ItemType.NETHERITKARD, true))) {
					
					if (p.getInventory().containsAtLeast(new ItemStack(Material.EMERALD), 6)) {
						p.getInventory().addItem(idec.getItem(ItemType.NETHERITKARD, false));
						p.getInventory().removeItemAnySlot(new ItemStack(Material.EMERALD, 6));
					} else {
						p.sendMessage(ChatColor.RED + "Nincs elég smaragdod!");
					}
					
				} else if (e.getCurrentItem().equals(idec.getItem(ItemType.NETHERITFEJSZE, true))) {
					
					if (p.getInventory().containsAtLeast(new ItemStack(Material.EMERALD), 11)) {
						p.getInventory().addItem(idec.getItem(ItemType.NETHERITFEJSZE, false));
						p.getInventory().removeItemAnySlot(new ItemStack(Material.EMERALD, 11));
					} else {
						p.sendMessage(ChatColor.RED + "Nincs elég smaragdod!");
					}
					
				} else if (e.getCurrentItem().equals(idec.getItem(ItemType.TOLGYCSEMETE, true))) {
					
					if(p.getInventory().containsAtLeast(new ItemStack(Material.GOLD_INGOT), 5)) {
						p.getInventory().addItem(idec.getItem(ItemType.TOLGYCSEMETE, false));
						p.getInventory().addItem(idec.getItem(ItemType.FOLD, false));
						p.getInventory().removeItemAnySlot(new ItemStack(Material.GOLD_INGOT, 5));
					} else {
						p.sendMessage(ChatColor.RED + "Nincs elég aranyad!");
					}
					
				} else if (e.getCurrentItem().equals(idec.getItem(ItemType.TOJAS, true))) {
					
					if(p.getInventory().containsAtLeast(new ItemStack(Material.EMERALD), 2)) {
						p.getInventory().addItem(idec.getItem(ItemType.TOJAS, false));
						p.getInventory().removeItemAnySlot(new ItemStack(Material.EMERALD, 2));
					} else {
						p.sendMessage(ChatColor.RED + "Nincs elég smaragdod!");
					}
					
				}
			} catch (Exception ex) {
				
			}
		}
	}
}
