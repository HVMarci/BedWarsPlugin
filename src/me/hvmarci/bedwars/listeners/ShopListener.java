package me.hvmarci.bedwars.listeners;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.HumanEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import me.hvmarci.bedwars.itemDeclarations.FizetoEszkoz;
import me.hvmarci.bedwars.itemDeclarations.ItemType;
import static me.hvmarci.bedwars.itemDeclarations.ItemDeclarations.getItem;

public class ShopListener implements Listener {

	Inventory inv = Bukkit.createInventory(null, 5 * 9, "Shop");

	@EventHandler
	public void onClickShop(PlayerInteractAtEntityEvent e) {
		if (e.getRightClicked().getType().equals(EntityType.VILLAGER)) {

			inv.clear();

			inv.setItem(0, getItem(ItemType.GYAPJU, true));
			inv.setItem(1, getItem(ItemType.DESZKA, true));
			inv.setItem(2, getItem(ItemType.ENDKO, true));
			inv.setItem(3, getItem(ItemType.OBSZIDIAN, true));
			inv.setItem(4, getItem(ItemType.TEGLA, true));
			inv.setItem(5, getItem(ItemType.KO, true));
			inv.setItem(6, getItem(ItemType.HOMOK, true));
			inv.setItem(7, getItem(ItemType.SODER, true));
			inv.setItem(9, getItem(ItemType.KOKARD, true));
			inv.setItem(10, getItem(ItemType.VASKARD, true));
			inv.setItem(11, getItem(ItemType.GYEMANTKARD, true));
			inv.setItem(12, getItem(ItemType.NETHERITKARD, true));
			inv.setItem(13, getItem(ItemType.NETHERITFEJSZE, true));
			inv.setItem(14, getItem(ItemType.IJ, true));
			inv.setItem(15, getItem(ItemType.SZAMSZERIJ, true));
			inv.setItem(16, getItem(ItemType.NYIL, true));
			inv.setItem(17, getItem(ItemType.SPEKTRALNYIL, true));
			inv.setItem(18, getItem(ItemType.TOLGYCSEMETE, true));
			inv.setItem(19, getItem(ItemType.FOLD, true));
			inv.setItem(20, getItem(ItemType.TOJAS, true));
			inv.setItem(21, getItem(ItemType.ENDERSZEM, true));
			inv.setItem(22, getItem(ItemType.LATHATATLANSAG, true));
			inv.setItem(23, getItem(ItemType.UGRASPOTI, true));
			inv.setItem(27, getItem(ItemType.HUS, true));
			inv.setItem(28, getItem(ItemType.CSONTLISZT, true));
			inv.setItem(36, getItem(ItemType.BORSZETT, true));
			inv.setItem(37, getItem(ItemType.VASSZETT, true));
			inv.setItem(38, getItem(ItemType.LANCSZETT, true));
			inv.setItem(39, getItem(ItemType.DIASZETT, true));
			inv.setItem(40, getItem(ItemType.NETHERITSZETT, true));

			e.getPlayer().openInventory(inv);
		}
	}

	@EventHandler
	public void onItemClick(InventoryClickEvent e) {

		HumanEntity p = e.getWhoClicked();

		if (e.getInventory().equals(inv)) {
			e.setCancelled(true);

			for (ItemType it : ItemType.values()) {
				if (e.getCurrentItem().equals(getItem(it, true))) {
					if (p.getInventory().containsAtLeast(new ItemStack(it.getFizetoEszkoz().getMaterial()), it.getAr())) {
						p.getInventory()
								.removeItemAnySlot(new ItemStack(it.getFizetoEszkoz().getMaterial(), it.getAr()));
						p.getInventory().addItem(getItem(it, false));
						return;
					} else {
						if (it.getFizetoEszkoz() == FizetoEszkoz.VAS || it.getFizetoEszkoz() == FizetoEszkoz.ARANY) {
							p.sendMessage(ChatColor.RED + "Nincs elég " + it.getFizetoEszkoz().getNev() + "ad!");
						} else {
							p.sendMessage(ChatColor.RED + "Nincs elég " + it.getFizetoEszkoz().getNev() + "od!");
						}
						return;
					}
				}
			}
//			
//			if (e.getCurrentItem().equals(idec.getItem(ItemType.GYAPJU, true))) {
//
//				if (p.getInventory().containsAtLeast(new ItemStack(Material.IRON_INGOT), 4)) {
//					p.getInventory().addItem(idec.getItem(ItemType.GYAPJU, false));
//					p.getInventory().removeItemAnySlot(new ItemStack(Material.IRON_INGOT, 4));
//				} else {
//					p.sendMessage(ChatColor.RED + "Nincs elég vasad!");
//				}
//
//			} else if (e.getCurrentItem().equals(idec.getItem(ItemType.DESZKA, true))) {
//
//				if (p.getInventory().containsAtLeast(new ItemStack(Material.GOLD_INGOT), 4)) {
//					p.getInventory().addItem(idec.getItem(ItemType.DESZKA, false));
//					p.getInventory().removeItemAnySlot(new ItemStack(Material.GOLD_INGOT, 4));
//				} else {
//					p.sendMessage(ChatColor.RED + "Nincs elég aranyad!");
//				}
//
//			} else if (e.getCurrentItem().equals(idec.getItem(ItemType.ENDKO, true))) {
//
//				if (p.getInventory().containsAtLeast(new ItemStack(Material.IRON_INGOT), 12)) {
//					p.getInventory().addItem(idec.getItem(ItemType.ENDKO, false));
//					p.getInventory().removeItemAnySlot(new ItemStack(Material.IRON_INGOT, 12));
//				} else {
//					p.sendMessage(ChatColor.RED + "Nincs elég vasad!");
//				}
//
//			} else if (e.getCurrentItem().equals(idec.getItem(ItemType.OBSZIDIAN, true))) {
//
//				if (p.getInventory().containsAtLeast(new ItemStack(Material.EMERALD), 4)) {
//					p.getInventory().addItem(idec.getItem(ItemType.OBSZIDIAN, false));
//					p.getInventory().removeItemAnySlot(new ItemStack(Material.EMERALD, 4));
//				} else {
//					p.sendMessage(ChatColor.RED + "Nincs elég smaragdod!");
//				}
//
//			} else if (e.getCurrentItem().equals(idec.getItem(ItemType.KOKARD, true))) {
//
//				if (p.getInventory().containsAtLeast(new ItemStack(Material.IRON_INGOT), 10)) {
//					p.getInventory().addItem(idec.getItem(ItemType.KOKARD, false));
//					p.getInventory().removeItemAnySlot(new ItemStack(Material.IRON_INGOT, 10));
//				} else {
//					p.sendMessage(ChatColor.RED + "Nincs elég vasad!");
//				}
//
//			} else if (e.getCurrentItem().equals(idec.getItem(ItemType.VASKARD, true))) {
//
//				if (p.getInventory().containsAtLeast(new ItemStack(Material.GOLD_INGOT), 7)) {
//					p.getInventory().addItem(idec.getItem(ItemType.VASKARD, false));
//					p.getInventory().removeItemAnySlot(new ItemStack(Material.GOLD_INGOT, 7));
//				} else {
//					p.sendMessage(ChatColor.RED + "Nincs elég aranyad!");
//				}
//
//			} else if (e.getCurrentItem().equals(idec.getItem(ItemType.GYEMANTKARD, true))) {
//
//				if (p.getInventory().containsAtLeast(new ItemStack(Material.EMERALD), 4)) {
//					p.getInventory().addItem(idec.getItem(ItemType.GYEMANTKARD, false));
//					p.getInventory().removeItemAnySlot(new ItemStack(Material.EMERALD, 4));
//				} else {
//					p.sendMessage(ChatColor.RED + "Nincs elég smaragdod!");
//				}
//
//			} else if (e.getCurrentItem().equals(idec.getItem(ItemType.NETHERITKARD, true))) {
//
//				if (p.getInventory().containsAtLeast(new ItemStack(Material.EMERALD), 6)) {
//					p.getInventory().addItem(idec.getItem(ItemType.NETHERITKARD, false));
//					p.getInventory().removeItemAnySlot(new ItemStack(Material.EMERALD, 6));
//				} else {
//					p.sendMessage(ChatColor.RED + "Nincs elég smaragdod!");
//				}
//
//			} else if (e.getCurrentItem().equals(idec.getItem(ItemType.NETHERITFEJSZE, true))) {
//
//				if (p.getInventory().containsAtLeast(new ItemStack(Material.EMERALD), 11)) {
//					p.getInventory().addItem(idec.getItem(ItemType.NETHERITFEJSZE, false));
//					p.getInventory().removeItemAnySlot(new ItemStack(Material.EMERALD, 11));
//				} else {
//					p.sendMessage(ChatColor.RED + "Nincs elég smaragdod!");
//				}
//
//			} else if (e.getCurrentItem().equals(idec.getItem(ItemType.TOLGYCSEMETE, true))) {
//
//				if (p.getInventory().containsAtLeast(new ItemStack(Material.GOLD_INGOT), 5)) {
//					p.getInventory().addItem(idec.getItem(ItemType.TOLGYCSEMETE, false));
//					p.getInventory().addItem(idec.getItem(ItemType.FOLD, false));
//					p.getInventory().removeItemAnySlot(new ItemStack(Material.GOLD_INGOT, 5));
//				} else {
//					p.sendMessage(ChatColor.RED + "Nincs elég aranyad!");
//				}
//
//			} else if (e.getCurrentItem().equals(idec.getItem(ItemType.TOJAS, true))) {
//
//				if (p.getInventory().containsAtLeast(new ItemStack(Material.EMERALD), 2)) {
//					p.getInventory().addItem(idec.getItem(ItemType.TOJAS, false));
//					p.getInventory().removeItemAnySlot(new ItemStack(Material.EMERALD, 2));
//				} else {
//					p.sendMessage(ChatColor.RED + "Nincs elég smaragdod!");
//				}
//
//			}
		}
	}
}
