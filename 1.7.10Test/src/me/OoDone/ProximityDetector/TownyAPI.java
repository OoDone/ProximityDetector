package me.OoDone.ProximityDetector;

import java.util.List;

import org.bukkit.Location;
import com.palmergames.bukkit.towny.db.TownyDataSource;
import com.palmergames.bukkit.towny.exceptions.NotRegisteredException;
import com.palmergames.bukkit.towny.exceptions.TownyException;
import com.palmergames.bukkit.towny.object.Resident;
import com.palmergames.bukkit.towny.object.Town;

public class TownyAPI {
	//public Towny towny;
	public Main main;
	//public TownyUniverse towny;
	TownyDataSource dataSource = main.getTownyUniverse().getDataSource();
	TownyAPI(Main main) {
		this.main = main;
	}
	
	@SuppressWarnings("deprecation")
	public List<Town> getTowns() {
		//System.out.println(TownyUniverse.getDataSource());
		for (Town town : dataSource.getTowns()) {
			System.out.println(town.getName());
		}
		return dataSource.getTowns();
	}
	
	@SuppressWarnings("deprecation")
	public Town getTown(String name) throws NotRegisteredException {
		return dataSource.getTown(name);
	}
	public List<Resident> getResidents(String town) throws NotRegisteredException {
		return getTown(town).getResidents();
	}
	
	public Location getTownSpawn(String town) throws NotRegisteredException, TownyException {
		return getTown(town).getSpawn();
	}
}
