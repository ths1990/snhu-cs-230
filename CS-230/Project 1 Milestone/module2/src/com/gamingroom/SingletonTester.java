package com.gamingroom;

/**
 * A class to test a singleton's behavior
 * @author coce@snhu.edu
 */
public class SingletonTester {

	public void testSingleton() {
		
		System.out.println("\nAbout to test the singleton...");
		
		//calls the getInstance method AFTER initial instance is created in main()
		//if successful, returns the 'Instance already created' message 
		GameService service = GameService.getInstance(); 
		
		// a simple for loop to print the games
		for (int i = 0; i < service.getGameCount(); i++) {
			System.out.println(service.getGame(i));
		}

	}
	
}
