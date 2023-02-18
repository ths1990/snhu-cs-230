package com.gamingroom;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

/**
 * A simple class to hold information about a game
 * 
 * <p>
 * Notice the overloaded constructor that requires
 * an id and name to be passed when creating.
 * Also note that no mutators (setters) defined so
 * these values cannot be changed once a game is
 * created.
 * </p>
 * 
 * @author coce@snhu.edu
 *
 */
public class Game extends Entity{

	
	

	//List of teams in a game
	private static List<Team> teams = new ArrayList<Team>();

	/**
	 * Constructor with an identifier and name, inherited from Entity class
	 */
	public Game(long id, String name) {
		this.id = id;
		this.name = name;
	}

	//Method to add team to a game
	public Team addTeam(String name) {
		
		//Default local instance
		Team team = null;
		
		//Iterator for team list
		Iterator<Team> teamsIterator = teams.iterator();
		
		//Iterates through team list and checks is team name exists - if yes, returns existing instance
		while (teamsIterator.hasNext()) {
			
			Team teamInstance = teamsIterator.next();
			
			if(teamInstance.getName().equalsIgnoreCase(name)) {
				team = teamInstance;
			}
			
		}
		
		//If team name cannot be found, adds new team to the list
		if (team == null) {
			GameService service = GameService.getInstance();
			
			team = new Team(service.getNextTeamId(),name);
			teams.add(team);
		}
		
		return team;
		
		
	}

	@Override
	public String toString() {
		
		return "Game [id=" + id + ", name=" + name + "]";
	}

}
