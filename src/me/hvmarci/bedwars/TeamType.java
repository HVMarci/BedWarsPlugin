package me.hvmarci.bedwars;

public enum TeamType {

	RED("piros", "§c"), BLUE("kék", "§9"), YELLOW("sárga", "§e"), GREEN("zöld", "§2");

	private final String magyarNev, color;

	TeamType(String magyarNev, String color) {
		this.magyarNev = magyarNev;
		this.color = color;
	}

	public String getNev() {
		return this.magyarNev;
	}

	public String getColor() {
		return this.color;
	}
}
