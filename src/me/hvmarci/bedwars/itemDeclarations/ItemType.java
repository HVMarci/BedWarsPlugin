package me.hvmarci.bedwars.itemDeclarations;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.potion.PotionType;

public enum ItemType {
	GYAPJU(Material.RED_WOOL, FizetoEszkoz.VAS, 4, 16), DESZKA(Material.OAK_PLANKS, FizetoEszkoz.ARANY, 4, 16),
	ENDKO(Material.END_STONE, FizetoEszkoz.VAS, 12, 12), OBSZIDIAN(Material.OBSIDIAN, FizetoEszkoz.SMARAGD, 4, 4),
	FAKARD(Material.WOODEN_SWORD, FizetoEszkoz.VAS, 4, 1), KOKARD(Material.STONE_SWORD, FizetoEszkoz.VAS, 10, 1),
	VASKARD(Material.IRON_SWORD, FizetoEszkoz.ARANY, 7, 1),
	GYEMANTKARD(Material.DIAMOND_SWORD, FizetoEszkoz.SMARAGD, 4, 1),
	NETHERITKARD(Material.NETHERITE_SWORD, FizetoEszkoz.SMARAGD, 6, 1),
	NETHERITFEJSZE(Material.NETHERITE_AXE, FizetoEszkoz.SMARAGD, 11, 1, new Enchantment[] { Enchantment.DAMAGE_ALL },
			new int[] { 2 }),
	TOLGYCSEMETE(Material.OAK_SAPLING, FizetoEszkoz.ARANY, 5, 2), FOLD(Material.DIRT, FizetoEszkoz.VAS, 10, 5),
	VILLAMPALCA(Material.STICK, FizetoEszkoz.GYEMANT, 10000, 1), TOJAS(Material.EGG, FizetoEszkoz.ARANY, 13, 16),
	HUS(Material.COOKED_BEEF, FizetoEszkoz.ARANY, 2, 8), TEGLA(Material.BRICKS, FizetoEszkoz.VAS, 16, 30),
	KO(Material.STONE, FizetoEszkoz.ARANY, 12, 8), HOMOK(Material.SAND, FizetoEszkoz.SMARAGD, 1, 20),
	SODER(Material.GRAVEL, FizetoEszkoz.SMARAGD, 1, 20), CSONTLISZT(Material.BONE_MEAL, FizetoEszkoz.ARANY, 10, 3),
	IJ(Material.BOW, FizetoEszkoz.ARANY, 12, 1), SZAMSZERIJ(Material.CROSSBOW, FizetoEszkoz.ARANY, 16, 1),
	NYIL(Material.ARROW, FizetoEszkoz.ARANY, 8, 28), SPEKTRALNYIL(Material.SPECTRAL_ARROW, FizetoEszkoz.ARANY, 8, 12),
	ENDERSZEM(Material.ENDER_PEARL, FizetoEszkoz.SMARAGD, 6, 2),
	LATHATATLANSAG(FizetoEszkoz.SMARAGD, 10, 1, PotionType.INVISIBILITY),
	UGRASPOTI(FizetoEszkoz.SMARAGD, 5, 1, PotionType.JUMP),
	BORSZETT(Material.LEATHER_CHESTPLATE, FizetoEszkoz.VAS, 10, 1),
	VASSZETT(Material.IRON_CHESTPLATE, FizetoEszkoz.ARANY, 12, 1),
	LANCSZETT(Material.CHAINMAIL_CHESTPLATE, FizetoEszkoz.ARANY, 16, 1),
	DIASZETT(Material.DIAMOND_CHESTPLATE, FizetoEszkoz.SMARAGD, 8, 1),
	NETHERITSZETT(Material.NETHERITE_CHESTPLATE, FizetoEszkoz.SMARAGD, 16, 1);

	private final Material mat;
	private final FizetoEszkoz fiz;
	private final int ar, db;
	private final Enchantment[] ench;
	private final int[] lvl;
	private final PotionType pot;

	ItemType(Material mat, FizetoEszkoz fiz, int ar, int db) {
		this.mat = mat;
		this.fiz = fiz;
		this.ar = ar;
		this.db = db;
		this.ench = null;
		this.lvl = null;
		this.pot = null;
	}

	ItemType(Material mat, FizetoEszkoz fiz, int ar, int db, Enchantment[] ench, int[] lvl) {
		this.mat = mat;
		this.fiz = fiz;
		this.ar = ar;
		this.db = db;
		this.ench = ench;
		this.lvl = lvl;
		this.pot = null;
	}
	
	/**
	 * Potiknak
	 * @param fiz Fizetõeszköz
	 * @param ar Ár
	 * @param db Darab
	 * @param pot Poti effekt
	 */
	ItemType(FizetoEszkoz fiz, int ar, int db, PotionType pot) {
		this.mat = Material.POTION;
		this.fiz = fiz;
		this.ar = ar;
		this.db = db;
		this.ench = null;
		this.lvl = null;
		this.pot = pot;
	}

	public Material getMaterial() {
		return this.mat;
	}

	public FizetoEszkoz getFizetoEszkoz() {
		return this.fiz;
	}

	public int getAr() {
		return this.ar;
	}

	public int getDarab() {
		return this.db;
	}

	public Enchantment[] getEnchantments() {
		return this.ench;
	}

	public int[] getEnchantmentLevels() {
		return this.lvl;
	}
	
	public PotionType getPotionType() {
		return this.pot;
	}
}
