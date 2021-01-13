package me.hvmarci.bedwars.listeners;

import org.bukkit.entity.Projectile;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileLaunchEvent;

public class EggThrowEvent implements Listener {
	
	@EventHandler
	public void onEgg(ProjectileLaunchEvent e) {
		//System.out.println(1);
		//System.out.println(e.getEntityType().toString());
		if (e.getEntityType() == EntityType.EGG) {
			//System.out.println(2);
			Projectile egg = e.getEntity();
			Location loc = egg.getLocation();
			
			if (loc.getBlock().getType() == Material.AIR) {
				loc.getBlock().setType(Material.RED_WOOL);
			}
		}
	}
	
}
