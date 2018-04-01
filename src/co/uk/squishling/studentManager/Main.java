package co.uk.squishling.studentManager;

public class Main {
	
	private static StudentList students = new StudentList();
	
	// Commands static object
	private static Commands commands = new Commands(students);
	
	// Main method
	public static void main(String[] args) {
		// Calls commands interaction loop method
		commands.interact();
	}
		
}
