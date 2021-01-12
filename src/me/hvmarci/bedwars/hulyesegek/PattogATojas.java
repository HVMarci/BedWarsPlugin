package me.hvmarci.bedwars.hulyesegek;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.util.Vector;

public class PattogATojas implements Listener {
	
	@EventHandler
	public void pattog(ProjectileHitEvent e) {
		if (e.getEntityType() == EntityType.EGG) {
			try {
			Vector vec = new Vector(Math.random()-0.5, 0.7, Math.random()-0.5);
			BlockFace bf = e.getHitBlockFace();
			World w = e.getHitBlock().getWorld();
			Location loc = e.getHitBlock().getLocation();
			System.out.println(bf.toString());
			switch (bf) {
				case DOWN:
					loc.add(0, -1, 0);
					vec.setY(-vec.getY());
					break;
				case EAST:
					loc.add(-1, 0, 0);
					//vec.setX((vec.getX()-0.5)/2);
					break;
					
				case WEST:
					loc.add(1,0,0);
					//vec.setX((vec.getX()+0.5)/2);
					break;
					
				case UP:
					loc.add(0,1,0);
					break;
					
				case NORTH:
					loc.add(0,0,1);
					//vec.setZ((vec.getZ()+0.5)/2);
					break;
					
				case SOUTH:
					loc.add(0,0,-1);
					//vec.setZ((vec.getZ()-0.5)/2);
					break;
				case NORTH_EAST:
					loc.add(-1,0,1);
					//vec.setZ((vec.getZ()+0.5)/2);
					//vec.setX((vec.getX()-0.5)/2);
					break;
				case NORTH_WEST:
					loc.add(1,0,1);
					//vec.setZ((vec.getZ()+0.5)/2);
					//vec.setX((vec.getX()+0.5)/2);
					break;
				case SOUTH_EAST:
					loc.add(-1,0,-1);
					//vec.setZ((vec.getZ()-0.5)/2);
					//vec.setX((vec.getX()-0.5)/2);
					break;
					
				case SOUTH_WEST:
					loc.add(1,0,-1);
					//vec.setZ((vec.getZ()-0.5)/2);
					//vec.setX((vec.getX()+0.5)/2);
					break;
				default:
					System.out.println("asd");
					break;
			}
			Entity egg = w.spawnEntity(loc, EntityType.CREEPER);
			vec.multiply(2);
			
			egg.setVelocity(vec);
			} catch (NullPointerException ex) {
				
			}
		}
	}

}
