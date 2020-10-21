package me.hvmarci.bedwars.Listeners;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import me.hvmarci.bedwars.Main;
import me.hvmarci.bedwars.Team;

public class BedBroke implements Listener {
	
	@EventHandler
	public void bedBreakEvent(BlockBreakEvent e) {
		Block b = e.getBlock();
		Player p = e.getPlayer();
		World w = Bukkit.getWorld(Main.mainWorld);
		
		if (b.getLocation().getWorld().equals(w)) {
			if (b.getType().equals(Material.RED_BED)) {
				w.getPlayers().forEach(i->{
					i.sendMessage("�cA �4piros �c�gyat ki�t�tte " + p.getDisplayName() + "�c!");
				});
				Team.getRedTeam().getPlayers().forEach(i->{
					Player ap = (Player) i;
					ap.sendTitle("", p.getDisplayName() + "�c ki�t�tte az �gyadat!");
				});
			} else if (b.getType().equals(Material.BLUE_BED)) {
				w.getPlayers().forEach(i->{
					i.sendMessage("�cA �bk�k �c�gyat ki�t�tte " + p.getDisplayName() + "�c!");
				});
				Team.getBlueTeam().getPlayers().forEach(i->{
					Player ap = (Player) i;
					ap.sendTitle("", p.getDisplayName() + "�c ki�t�tte az �gyadat!");
				});
			} else if (b.getType().equals(Material.YELLOW_BED)) {
				w.getPlayers().forEach(i->{
					i.sendMessage("�cA �6s�rga �c�gyat ki�t�tte " + p.getDisplayName() + "�c!");
				});
				Team.getYellowTeam().getPlayers().forEach(i->{
					Player ap = (Player) i;
					ap.sendTitle(p.getDisplayName() + "�c ki�t�tte az �gyadat!", "");
				});
			} else if (b.getType().equals(Material.GREEN_BED)) {
				w.getPlayers().forEach(i->{
					i.sendMessage("�cA �2z�ld �c�gyat ki�t�tte " + p.getDisplayName() + "�c!");
				});
				Team.getGreenTeam().getPlayers().forEach(i->{
					Player ap = (Player) i;
					ap.sendTitle(p.getDisplayName() + "�c ki�t�tte az �gyadat!", "");
				});
			}
		}
	}
	
}
