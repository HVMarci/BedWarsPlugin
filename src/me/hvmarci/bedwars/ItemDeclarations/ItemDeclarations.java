package me.hvmarci.bedwars.ItemDeclarations;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemDeclarations {
	
	private ItemMeta createDefaultItemMeta(ItemMeta im, String nev, String ar, boolean hasEnchant, boolean shop) {
		List<String> lore = new ArrayList<>();
		
		//lore.add(nev);
		//lore.add("\n");
		lore.add("Ár: " + ar);
		
		if (!hasEnchant && shop) {
			im.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
			im.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		}
		if (shop)
			im.setLore(lore);
		im.setDisplayName(nev);
		
		return im;
	}
	
	public ItemStack getItem(ItemType material, boolean shop) {
		ItemStack is = new ItemStack(Material.DIRT);
		ItemMeta im = is.getItemMeta();
		String nev;
		String ar;
		boolean hasEnchant;
		
		switch (material) {
		case GYAPJU:
			nev = "Gyapjú";
			ar = "4 vas";
			hasEnchant = false;
			is.setType(Material.RED_WOOL);
			is.setAmount(16);
			break;
			
		case DESZKA:
			nev = "Deszka";
			ar = "4 arany";
			if (Math.random() < 0.001) ar += "\nPala sajt vágódeszka 2 rozsdamentes acél késsel!";
			hasEnchant = false;
			is.setType(Material.OAK_PLANKS);
			is.setAmount(16);
			break;
			
		case ENDKO:
			nev = "Endkõ";
			ar = "12 vas";
			hasEnchant = false;
			is.setType(Material.END_STONE);
			is.setAmount(12);
			break;
			
		case OBSZIDIAN:
			nev = "Obszidián";
			ar = "4 smaragd";
			hasEnchant = false;
			is.setType(Material.OBSIDIAN);
			is.setAmount(4);
			break;
			
		case KOKARD:
			nev = "Kõkard";
			ar = "10 vas";
			if (Math.random() < 0.01) ar += "\nHát én nem hiszlek el téged...";
			hasEnchant = false;
			is.setType(Material.STONE_SWORD);
			break;
			
		case VASKARD:
			nev = "Vaskard";
			ar = "7 arany";
			if (Math.random() < 0.05) ar += "\nA hülyéknek sem éri meg...";
			hasEnchant = false;
			is.setType(Material.IRON_SWORD);
			break;
		
		case GYEMANTKARD:
			nev = "Gyémántkard";
			ar = "4 smaragd";
			if (Math.random() < 0.01) ar += "\nMost komolyan meg akarod venni???";
			hasEnchant = false;
			is.setType(Material.DIAMOND_SWORD);
			break;
			
		case NETHERITKARD:
			nev = "Netheritkard";
			ar = "6 smaragd";
			hasEnchant = false;
			is.setType(Material.NETHERITE_SWORD);
			break;
			
		case NETHERITFEJSZE:
			nev = "Netheritfejsze";
			ar = "11 smaragd";
			hasEnchant = true;
			im.addEnchant(Enchantment.DAMAGE_ALL, 2, true);
			is.setType(Material.NETHERITE_AXE);
			break;
			
		case TOLGYCSEMETE:
			nev = "Tölgycsemete";
			ar = "5 arany";
			hasEnchant = false;
			is.setType(Material.OAK_SAPLING);
			is.setAmount(2);
			break;
			
		case FOLD:
			nev = "Föld";
			ar = "Grátisz";
			hasEnchant = false;
			is.setType(Material.DIRT);
			is.setAmount(2);
			break;
			
		case TOJAS:
			nev = "Bridge";
			ar = "2 smaragd";
			hasEnchant = false;
			is.setType(Material.EGG);
			break;
			
		case FAKARD:
			nev = "§c:§b)";
			ar = "Örök rabszolgaság";
			hasEnchant = true;
			im.addEnchant(Enchantment.SWEEPING_EDGE, 30, true);
			im.addEnchant(Enchantment.DAMAGE_ALL, 30, true);
			im.addEnchant(Enchantment.KNOCKBACK, 1, true);
			im.addEnchant(Enchantment.DAMAGE_ARTHROPODS, 30, true);
			im.addEnchant(Enchantment.DAMAGE_UNDEAD, 30, true);
			im.addEnchant(Enchantment.DIG_SPEED, 30, true);
			im.addEnchant(Enchantment.FIRE_ASPECT, 1, true);
			is.setType(Material.WOODEN_SWORD);
			break;
			
		case VILLAMPALCA:
			nev = "Thor kalapácsa";
			ar = "neked semmi";
			hasEnchant = false;
			is.setType(Material.STICK);
			break;
			
		default:
			return null;
		}
		
		im = createDefaultItemMeta(im, nev, ar, hasEnchant, shop);
		is.setItemMeta(im);
		return is;
	}
	
	/*public ItemStack gyapju() {
		ItemStack is = new ItemStack(Material.RED_WOOL, 16);
		ItemMeta im = is.getItemMeta();
		
		is.setItemMeta(createDefaultItemMeta(im, "Gyapjú", "4 vas", false, true));
		return is;
	}
	
	public ItemStack deszka() {
		ItemStack is = new ItemStack(Material.OAK_PLANKS, 16);
		ItemMeta im = is.getItemMeta();
		
		is.setItemMeta(createDefaultItemMeta(im, "Deszka", "4 arany", false, true));
		return is;
	}
	
	public ItemStack endKo() {
		ItemStack is = new ItemStack(Material.END_STONE, 12);
		ItemMeta im = is.getItemMeta();
		
		is.setItemMeta(createDefaultItemMeta(im, "Endkõ", "12 vas", false, true));
		return is;
	}
	
	public ItemStack obszidian() {
		ItemStack is = new ItemStack(Material.OBSIDIAN, 4);
		ItemMeta im = is.getItemMeta();

		is.setItemMeta(createDefaultItemMeta(im, "Obszidián", "4 smaragd", false, true));
		return is;
	}
	
	public ItemStack koKard() {
		ItemStack is = new ItemStack(Material.STONE_SWORD);
		ItemMeta im = is.getItemMeta();

		is.setItemMeta(createDefaultItemMeta(im, "Kõkard", "10 vas", false, true));
		return is;
	}
	
	public ItemStack vasKard() {
		ItemStack is = new ItemStack(Material.IRON_SWORD);
		ItemMeta im = is.getItemMeta();

		is.setItemMeta(createDefaultItemMeta(im, "Vaskard", "7 arany", false, true));
		return is;
	}
	
	public ItemStack gyemantKard() {
		ItemStack is = new ItemStack(Material.DIAMOND_SWORD);
		ItemMeta im = is.getItemMeta();

		is.setItemMeta(createDefaultItemMeta(im, "Gyémántkard", "4 smaragd", false, true));
		return is;
	}
	
	public ItemStack netheritKard() {
		ItemStack is = new ItemStack(Material.NETHERITE_SWORD);
		ItemMeta im = is.getItemMeta();

		is.setItemMeta(createDefaultItemMeta(im, "Netheritkard", "6 smaragd", false, true));
		return is;
	}
	
	public ItemStack tolgyCsemete() {
		ItemStack is = new ItemStack(Material.OAK_SAPLING, 2);
		ItemMeta im = is.getItemMeta();

		is.setItemMeta(createDefaultItemMeta(im, "Tölgyfa csemete", "5 arany", false, true));
		return is;
	}
	
	public ItemStack faKard() {
		ItemStack is = new ItemStack(Material.WOODEN_SWORD);
		ItemMeta im = createDefaultItemMeta(is.getItemMeta(), "§c:§b)", "", true, false);
		
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
	
	public ItemStack netheritBalta() {
		ItemStack is = new ItemStack(Material.NETHERITE_AXE);
		ItemMeta im = createDefaultItemMeta(is.getItemMeta(), "Netheritfejsze", "11 smaragd", true, true);
		
		im.addEnchant(Enchantment.DAMAGE_ALL, 2, true);
		im.removeEnchant(Enchantment.PROTECTION_ENVIRONMENTAL);
		im.removeItemFlags(ItemFlag.HIDE_ENCHANTS);
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
	}*/
}
