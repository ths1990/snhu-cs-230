package com.gamingroom;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * A singleton service for the game engine
 * 
 * @author coce@snhu.edu
 */
public class GameService {

	/**
	 * A list of the active games
	 */
	private static List<Game> games = new ArrayList<Game>();

	/*
	 * Holds the next game identifier
	 */
	private static long nextGameId = 1;

	// FIXME: Add missing pieces to turn this class a singleton
	
	//Private variable used to determine existence of GameService Instance
	private static GameService service = null;
	
	
	//Default singleton constructor
	private GameService() {
		
	}
	
	
	public static GameService getInstance() {
		
		//Check for existence of GameService instance
		if (service == null) {
			service = new GameService();
			System.out.println("New instance created.");
		}
		
		//Returns message if instance already created
		else {
			System.out.println("Instance already created.");
		}
		return service;
	}
	
	
	
	

	/**
	 * Construct a new game instance
	 * 
	 * @param name the unique name of the game
	 * @return the game instance (new or existing)
	 */
	public Game addGame(String name) {

		// a local game instance
		Game game = null;

		
		// Iterator for array list games
		Iterator<Game> gamesIterator = games.iterator();
		
		//Iterates through the list, so long as the list has a next value
		while (gamesIterator.hasNext()) {
			
			//Assigns the next value to gameInstance variable
			Game gameInstance = gamesIterator.next();
			
			//If the same name is entered for the game created, it will only return the value of the 1st instance 
			//created with the same name, not case sensitive
			if(gameInstance.getName().equalsIgnoreCase(name)) {
				
				return gameInstance;
			}
			
		}
		
		// if not found, make a new game instance and add to list of games
		if (game == null) {
			game = new Game(nextGameId++, name);
			games.add(game);
		}

		// return the new/existing game instance to the caller
		return game;
	}

	/**
	 * Returns the game instance at the specified index.
	 * <p>
	 * Scope is package/local for testing purposes.
	 * </p>
	 * @param index index position in the list to return
	 * @return requested game instance
	 */
	Game getGame(int index) {
		return games.get(index);
	}
	
	/**
	 * Returns the game instance with the specified id.
	 * 
	 * @param id unique identifier of game to search for
	 * @return requested game instance
	 */
	public Game getGame(long id) {

		// a local game instance
		Game game = null;

		//Iterator for array list games
		Iterator<Game> gamesIterator = games.iterator();
		
		//Iterates through game list
		while (gamesIterator.hasNext()) {
			
			//Assigns next value of games list to variable
			Game gameInstance = gamesIterator.next();
			
			//Checks against game id, if id already exists, returns existing instance
			if(gameInstance.getId() == id) {
				
				return gameInstance;
			}
			
		}
		
		return game;
	}

	/**
	 * Returns the game instance with the specified name.
	 * 
	 * @param name unique name of game to search for
	 * @return requested game instance
	 */
	public Game getGame(String name) {

		// a local game instance
		Game game = null;

		//Iterator for array list games
		Iterator<Game> gamesIterator = games.iterator();
		
		//Iterates through games list
		while(gamesIterator.hasNext()) {
			
			//Assigns next value in list through each iteration to variable
			Game gameInstance = gamesIterator.next();
			
			//If game name already exists in list, assigns gameInstance to local variable
			if (gameInstance.getName().equalsIgnoreCase(name)) {
				game = gameInstance;
			}
			
		}
		

		return game;
	}

	/**
	 * Returns the number of games currently active
	 * 
	 * @return the number of games currently active
	 */
	public int getGameCount() {
		return games.size();
	}
}
