package co.uk.squishling.studentManager;

public class Main {
	
	// Commands static object
	private static Commands commands = new Commands();
	
	// Main method
	public static void main(String[] args) {
		// Calls commands interaction loop method
		commands.interact();
	}
		
}
