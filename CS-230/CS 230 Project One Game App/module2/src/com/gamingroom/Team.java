package com.gamingroom;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

/**
 * A simple class to hold information about a team
 * <p>
 * Notice the overloaded constructor that requires
 * an id and name to be passed when creating.
 * Also note that no mutators (setters) defined so
 * these values cannot be changed once a team is
 * created.
 * </p>
 * @author coce@snhu.edu
 *
 */
public class Team extends Entity {
	
	//List of players on a team
	private static List<Player> players = new ArrayList<Player>();

	
	/*
	 * Constructor with an identifier and name inherited from Entity class
	 */
	public Team(long id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public Player addPlayer(String name) {
		
		//Sets default local instance of player
		Player player = null;
		
		//Iterator for Player List
		Iterator<Player> playersIterator = players.iterator();
		
		//Iterates through player list
		while(players.iterator().hasNext()) {
			
			Player playerInstance = playersIterator.next();
			
			//Checks if player name exists, if yes - returns existing instance
			if(playerInstance.getName().equalsIgnoreCase(name)) {
				
				player = playerInstance;
				
			}
			
		}
		
		//If player name cannot be found, creates new instance of player and adds to list
		if(player == null) {
			
			GameService service = GameService.getInstance();
			
			player = new Player(service.getNextPlayerId(), name);
			players.add(player);
			
		}
		
		return player;
		
	}



	@Override
	public String toString() {
		return "Team [id=" + id + ", name=" + name + "]";
	}
}
