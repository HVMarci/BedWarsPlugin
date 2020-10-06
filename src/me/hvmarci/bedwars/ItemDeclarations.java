package me.hvmarci.bedwars;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemDeclarations {
	
	private ItemMeta createDefaultItemMeta(ItemMeta im, String nev, String ar) {
		List<String> lore = new ArrayList<>();
		
		//lore.add(nev);
		//lore.add("\n");
		lore.add("Ár: " + ar);
		
		im.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
		im.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		im.setLore(lore);
		im.setDisplayName(nev);
		
		return im;
	}
	
	public ItemStack gyapju() {
		ItemStack is = new ItemStack(Material.RED_WOOL, 16);
		ItemMeta im = is.getItemMeta();
		
		is.setItemMeta(createDefaultItemMeta(im, "Gyapjú", "4 vas"));
		return is;
	}
	
	public ItemStack deszka() {
		ItemStack is = new ItemStack(Material.OAK_PLANKS, 16);
		ItemMeta im = is.getItemMeta();
		
		is.setItemMeta(createDefaultItemMeta(im, "Deszka", "4 arany"));
		return is;
	}
	
	public ItemStack endKo() {
		ItemStack is = new ItemStack(Material.END_STONE, 12);
		ItemMeta im = is.getItemMeta();
		
		is.setItemMeta(createDefaultItemMeta(im, "Endkõ", "12 vas"));
		return is;
	}
	
	public ItemStack obszidian() {
		ItemStack is = new ItemStack(Material.OBSIDIAN, 4);
		ItemMeta im = is.getItemMeta();

		is.setItemMeta(createDefaultItemMeta(im, "Obszidián", "4 smaragd"));
		return is;
	}
	
	public ItemStack koKard() {
		ItemStack is = new ItemStack(Material.STONE_SWORD);
		ItemMeta im = is.getItemMeta();

		is.setItemMeta(createDefaultItemMeta(im, "Kõkard", "10 vas"));
		return is;
	}
	
	public ItemStack vasKard() {
		ItemStack is = new ItemStack(Material.IRON_SWORD);
		ItemMeta im = is.getItemMeta();

		is.setItemMeta(createDefaultItemMeta(im, "Vaskard", "7 arany"));
		return is;
	}
	
	public ItemStack gyemantKard() {
		ItemStack is = new ItemStack(Material.DIAMOND_SWORD);
		ItemMeta im = is.getItemMeta();

		is.setItemMeta(createDefaultItemMeta(im, "Gyémántkard", "3 smaragd"));
		return is;
	}
	
	public ItemStack netheritKard() {
		ItemStack is = new ItemStack(Material.NETHERITE_SWORD);
		ItemMeta im = is.getItemMeta();

		is.setItemMeta(createDefaultItemMeta(im, "Netheritkard", "6 smaragd"));
		return is;
	}
	
	public ItemStack tolgyCsemete() {
		ItemStack is = new ItemStack(Material.OAK_SAPLING, 2);
		ItemMeta im = is.getItemMeta();

		is.setItemMeta(createDefaultItemMeta(im, "Tölgyfa csemete", "5 arany"));
		return is;
	}
	
	public ItemStack faKard() {
		ItemStack is = new ItemStack(Material.WOODEN_SWORD);
		ItemMeta im = is.getItemMeta();
		
		im.addEnchant(Enchantment.SWEEPING_EDGE, 30, true);
		im.addEnchant(Enchantment.DAMAGE_ALL, 30, true);
		im.addEnchant(Enchantment.KNOCKBACK, 1, true);
		im.addEnchant(Enchantment.DAMAGE_ARTHROPODS, 30, true);
		im.addEnchant(Enchantment.DAMAGE_UNDEAD, 30, true);
		im.addEnchant(Enchantment.DIG_SPEED, 30, true);
		im.addEnchant(Enchantment.FIRE_ASPECT, 1, true);
		im.setDisplayName("§c:§b)");
		
		is.setItemMeta(im);
		return is;
	}
	
	public ItemStack villamPalca() {
		ItemStack is = new ItemStack(Material.STICK);
		ItemMeta im = is.getItemMeta();
		
		im.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 30, true);
		im.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		im.setDisplayName("§bTHOR Kalapácsa");
		
		is.setItemMeta(im);
		return is;
	}
}
