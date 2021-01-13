package me.hvmarci.bedwars;

public enum TeamType {

	RED("piros", "�c"), BLUE("k�k", "�9"), YELLOW("s�rga", "�e"), GREEN("z�ld", "�2");

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
