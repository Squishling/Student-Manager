package co.uk.squishling.studentManager;

import java.util.Scanner;

public class Commands {
	
	// Variables
	private Module module = new Module();
	Scanner input = new Scanner(System.in);
	
	// Main interaction loop method
	public void interact() {
		while (true) {
			// Asks for command
			System.out.println("Please specify an action.\nview | add | remove | add_grade | best");
			String in = input.nextLine();
			
			// If view...
			if (in.equals("view")) {
				module.viewStudents();
			}
			
			// If add...
			if (in.equals("add")) {
				add();
			}
			
			// If remove...
			if (in.equals("remove")) {
				remove();
			}
			
			// If add_grade...
			if (in.equals("add_grade")) {
				addGrade();
			}
			
			// If best...
			if (in.equals("best")) {
				System.out.println(module.bestStudent());
			}
		}
	}
	
	// Add student command method
	public void add() {
		// Asks for name
		System.out.println("What is the name of the new student?");
		String inAddName = input.nextLine();
		
		// Asks for age
		System.out.println("How old is " + inAddName + "?");
		int inAddAge = input.nextInt();
		
		// Adds student and views all students
		module.addStudent(inAddName, inAddAge);
		module.viewStudents();
	}
	
	// Remove student command method
	public void remove() {
		// View students
		module.viewStudents();
		
		// Asks for student index
		System.out.println("What is is the index of the student you want to delete? (the number displayed on the far left)");
		int inRemoveIndex = input.nextInt();
		
		// Checks if the index is in the correct range
		if (inRemoveIndex > -1 && inRemoveIndex < module.getStudents().size()) {
			// Removes the student
			module.removeStudent(inRemoveIndex);
		} else {
			// Error message
			System.out.println("Please enter an index in the range of students.");
		}
	}
	
	// Add grade command method
	public void addGrade() {
		// Views students
		module.viewStudents();
		
		// Asks for a student index
		System.out.println("What is is the index of the student you want to add a grade to? (the number displayed on the far left)");
		int inAddGradeIndex = input.nextInt();
		
		// Checks if the student index is within the right range
		if (inAddGradeIndex > -1 && inAddGradeIndex < module.getStudents().size()) {
			// Asks for a grade
			System.out.println("What grade do you want to add to that student? (numbers 1-9)");
			int inAddGradeGrade = input.nextInt();
			
			// Checks if the grade is within the correct range
			if (inAddGradeGrade > 0 && inAddGradeGrade < 10) {
				// Adds the grade
				module.getStudent(inAddGradeIndex).addGrade(inAddGradeGrade);
			} else {
				// Error message
				System.out.println("Please enter an integer between one and nine.");
			}
		} else {
			// Error message
			System.out.println("Please enter an index in the range of students.");
		}
	}
	
}
