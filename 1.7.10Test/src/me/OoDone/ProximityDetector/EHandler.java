package me.OoDone.ProximityDetector;


import java.util.Timer;
import java.util.TimerTask;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import com.palmergames.bukkit.towny.exceptions.TownyException;
import com.palmergames.bukkit.towny.object.Town;

import github.scarsz.discordsrv.util.DiscordUtil;

public class EHandler implements Listener{
	public Main main;
	public int dist = 300;
	public int check = 10; //in seconds
	
 	EHandler(Main main) {
		this.main = main;	
		Timer timer = new Timer();
		
		timer.schedule(new TimerTask() {
		  @SuppressWarnings("deprecation")
			@Override
		  public void run() {
		  	TownyAPI townyAPI = new TownyAPI(main);
		  	for (Town town : townyAPI.getTowns()) {
		  		for (Player player : Bukkit.getServer().getOnlinePlayers()) {
		  			double distance = -1;
							try {
								System.out.println("xd1 " + distance);
								distance = player.getLocation().distance(town.getSpawn());
							} catch (TownyException e) {
								e.printStackTrace();
							}
							System.out.println("xd2 " + distance);
							if ((distance < dist) && (!town.hasResident(player.getName()))) {
								System.out.println("xd");
								DiscordUtil.sendMessage(DiscordUtil.getTextChannelById("779821667328327711"), player.getName() + " is " + distance + " blocks away from " + town.getName());
							}
		  		}
		  	}
		  		// loop all players within 10 blocks of a towny spawn
		  		//check if they are in that town
		  		//if they aren't in the town log to discord, if they are in the town, stop
		  }
		}, 3000, check * 1000); //runs the task every {interval} milliseconds and starts the task at {starttaskdelay} in milliseconds
	}
}
