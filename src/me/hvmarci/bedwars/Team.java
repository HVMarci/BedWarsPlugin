package me.hvmarci.bedwars;

import java.util.HashMap;

import org.bukkit.entity.Player;

public class Team {
//	private static List<String> redTeam = new ArrayList<String>();
//	private static List<String> blueTeam = new ArrayList<String>();
//	private static List<String> greenTeam = new ArrayList<String>();
//	private static List<String> yellowTeam = new ArrayList<String>();
	private static org.bukkit.scoreboard.Team redTeam = Main.scb.getTeam("redTeam");
	private static org.bukkit.scoreboard.Team blueTeam = Main.scb.getTeam("blueTeam");
	private static org.bukkit.scoreboard.Team greenTeam = Main.scb.getTeam("greenTeam");
	private static org.bukkit.scoreboard.Team yellowTeam = Main.scb.getTeam("yellowTeam");
	private static HashMap<TeamType, AliveType> elok = new HashMap<>();

	public static void addToTeam(TeamType type, Player p) {

		if (isInTeam(p, type)) {
			p.sendMessage("§cYou are already in this team!");
			return;
		}

		switch (type) {
		case RED:
			redTeam.addPlayer(p);
//			redTeam.add(p.getName());
//			p.setPlayerListName(ChatColor.RED + p.getName());
//			p.setDisplayName(ChatColor.RED + p.getName());
//			p.setCustomName(ChatColor.RED + p.getName());
//			p.setCustomNameVisible(true);
			break;

		case BLUE:
			blueTeam.addPlayer(p);
//			blueTeam.add(p.getName());
//			p.setPlayerListName(ChatColor.BLUE + p.getName());
//			p.setDisplayName(ChatColor.BLUE + p.getName());
//			p.setCustomName(ChatColor.BLUE + p.getName());
//			p.setCustomNameVisible(true);
			break;

		case GREEN:
			greenTeam.addPlayer(p);
//			greenTeam.add(p.getName());
//			p.setPlayerListName(ChatColor.GREEN + p.getName());
//			p.setDisplayName(ChatColor.GREEN + p.getName());
//			p.setCustomName(ChatColor.GREEN + p.getName());
//			p.setCustomNameVisible(true);
			break;

		case YELLOW:
			yellowTeam.addPlayer(p);
//			yellowTeam.add(p.getName());
//			p.setPlayerListName(ChatColor.YELLOW + p.getName());
//			p.setDisplayName(ChatColor.YELLOW + p.getName());
//			p.setCustomName(ChatColor.YELLOW + p.getName());
//			p.setCustomNameVisible(true);
			break;

		default:
			break;
		}
		p.sendMessage("Added to " + type.toString() + " team!");
	}

	public static boolean isInTeam(Player p, TeamType type) {
		switch (type) {
		case RED:
			return redTeam.hasPlayer(p);

		case BLUE:
			return blueTeam.hasPlayer(p);

		case GREEN:
			return greenTeam.hasPlayer(p);

		case YELLOW:
			return yellowTeam.hasPlayer(p);

		default:
			return false;
		}
	}

	public static boolean isInTeam(Player p) {

		return redTeam.hasPlayer(p) || blueTeam.hasPlayer(p) || greenTeam.hasPlayer(p) || yellowTeam.hasPlayer(p);
	}

	public static void clearTeam(TeamType type) {
		switch (type) {
		case RED:
			redTeam.getPlayers().forEach(i -> {
				redTeam.removePlayer(i);
			});

			break;

		case BLUE:
			blueTeam.getPlayers().forEach(i -> {
				blueTeam.removePlayer(i);
			});
			break;

		case GREEN:
			greenTeam.getPlayers().forEach(i -> {
				greenTeam.removePlayer(i);
			});
			break;

		case YELLOW:
			yellowTeam.getPlayers().forEach(i -> {
				yellowTeam.removePlayer(i);
			});
			break;

		default:
			break;
		}
	}

	public static void clearTeams() {
		clearTeam(TeamType.RED);
		clearTeam(TeamType.BLUE);
		clearTeam(TeamType.GREEN);
		clearTeam(TeamType.YELLOW);
	}

	public static org.bukkit.scoreboard.Team getRedTeam() {
		return redTeam;
	}

	public static org.bukkit.scoreboard.Team getBlueTeam() {
		return blueTeam;
	}

	public static org.bukkit.scoreboard.Team getGreenTeam() {
		return greenTeam;
	}

	public static org.bukkit.scoreboard.Team getYellowTeam() {
		return yellowTeam;
	}

	public static TeamType getTeamType(Player p) {
		if (!isInTeam(p))
			return null;
		if (redTeam.hasPlayer(p))
			return TeamType.RED;
		if (blueTeam.hasPlayer(p))
			return TeamType.BLUE;
		if (greenTeam.hasPlayer(p))
			return TeamType.GREEN;
		if (yellowTeam.hasPlayer(p))
			return TeamType.YELLOW;
		return null;
	}

	public static org.bukkit.scoreboard.Team getTeam(TeamType type) {
		switch (type) {
		case RED:
			return redTeam;
		case BLUE:
			return blueTeam;
		case GREEN:
			return greenTeam;
		case YELLOW:
			return yellowTeam;
		default:
			return null;
		}
	}

	public static void resetElok() {
		elok.clear();
		for (TeamType t : TeamType.values()) {
			elok.put(t, AliveType.EL);
		}
	}

	public static void halottTeam(TeamType t) {
		elok.remove(t);
		elok.put(t, AliveType.NINCSAGY);
	}
	
	public static void mindenkihalottTeam(TeamType t) {
		elok.remove(t);
		elok.put(t, AliveType.HALOTT);
	}

	public static AliveType getElo(TeamType t) {
		return elok.get(t);
	}

	public static boolean win() {
		int elCounter = 0, nincsagyCounter = 0, halottCounter = 0;
		
		for (TeamType t : TeamType.values()) {
			switch (getElo(t)) {
			case EL:
				elCounter++;
				break;
				
			case HALOTT:
				halottCounter++;
				break;
				
			case NINCSAGY:
				nincsagyCounter++;
				break;
			
			default:
				break;
			}
		}
		
		System.out.println(elCounter + ", " + nincsagyCounter + ", " + halottCounter);

		if (elCounter == 1 && nincsagyCounter == 0)
			return true;
		else
			return false;
	}
	
	public static TeamType getWinner() {
		if (!win()) {
			throw new RuntimeException("Még nem nyert senki!");
		} else {
			TeamType elo = TeamType.YELLOW;
			
			for (TeamType t : TeamType.values()) {
				switch (getElo(t)) {
				case EL:
					elo = t;
					break;
				
				default:
					break;
				}
			}
			
			return elo;
		}
	}
	
}
