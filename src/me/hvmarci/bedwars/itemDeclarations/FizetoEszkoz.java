package me.hvmarci.bedwars.itemDeclarations;

import org.bukkit.Material;

public enum FizetoEszkoz {

	VAS(Material.IRON_INGOT, "vas"), ARANY(Material.GOLD_INGOT, "arany"), SMARAGD(Material.EMERALD, "smaragd"),
	GYEMANT(Material.DIAMOND, "gyémánt");

	private final Material mat;
	private final String nev;
	
	FizetoEszkoz(Material m, String nev) {
		this.mat = m;
		this.nev = nev;
	}

	public Material getMaterial() {
		return this.mat;
	}
	
	public String getNev() {
		return this.nev;
	}

}
