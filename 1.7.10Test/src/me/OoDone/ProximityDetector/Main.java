package me.OoDone.ProximityDetector;


import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import com.palmergames.bukkit.towny.Towny;
import com.palmergames.bukkit.towny.object.TownyUniverse;

public class Main extends JavaPlugin implements Listener {
	private Towny towny;
	@Override
	public void onEnable() {
		Bukkit.getServer().getPluginManager().registerEvents(new EHandler(this), this);
		towny = (Towny) Bukkit.getPluginManager().getPlugin("Towny");
	}
	@Override
	public void onDisable() {
		
	}
	public TownyUniverse getTownyUniverse(){
	   return towny.getTownyUniverse();
	}
}
