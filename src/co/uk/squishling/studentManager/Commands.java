package co.uk.squishling.studentManager;

import java.util.Scanner;

public class Commands {
	
	// Variables
	private FileData fileData = new FileData();
	private Module module = new Module();
	Scanner input = new Scanner(System.in);
	
	// Main interaction loop method
	public void interact() {
		while (true) {
			// Asks for command
			System.out.println("Please specify an action.\nsave | load | view | add | remove | edit_name | edit_age | add_grade | edit_grade | remove_grade | best");
			String in = input.nextLine();
			
			// If save...
			if (in.equals("save")) {
				save();
			}
			
			// If load...
			if (in.equals("load")) {
				load();
			}
			
			// If view...
			if (in.equals("view")) {
				module.viewStudents();
			}
			
			// If add...
			if (in.equals("add")) {
				add();
			}
			
			// If edit_name...
			if (in.equals("edit_name")) {
				editNameCmd();
			}
			
			// If edit_age...
			if (in.equals("edit_age")) {
				editAge();
			}
			
			// If remove...
			if (in.equals("remove")) {
				remove();
			}
			
			// If add_grade...
			if (in.equals("add_grade")) {
				addGrade();
			}
			
			// If edit_grade...
			if (in.equals("edit_grade")) {
				editGrade();
			}
			
			// If remove_grade...
			if (in.equals("remove_grade")) {
				removeGrade();
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
	
	// Edit name command method
	public void editNameCmd() {
		// Asks for a student index
		System.out.println("What is the index of the student whoose name you want to edit? (the number displayed on the far left)");
		int inEditNameIndex = input.nextInt();
		input.nextLine();
		
		// Checks if the index is in the correct range
		if (inEditNameIndex > -1 && inEditNameIndex < module.getStudents().size()) {
			// Asks for a new name
			System.out.println("What do you want its name to be?");
			String inEditNameName = input.nextLine();
			
			// Changes the name
			module.getStudent(inEditNameIndex).editName(inEditNameName);
			module.viewStudents();
		} else {
			// Error message
			System.out.println("Please enter an index in the range of students.");
		}
		
	}
	
	public void editAge() {
		// Asks for a student index
		System.out.println("What is is the index of the student you want to edit its age? (the number displayed on the far left)");
		int inEditAgeIndex = input.nextInt();
		
		// Checks if the index is in the correct range
		if (inEditAgeIndex > -1 && inEditAgeIndex < module.getStudents().size()) {
			// Asks for a new age
			System.out.println("What do you want its age to be?");
			int inEditAgeAge = input.nextInt();
			input.nextLine();
			
			// Changes the age
			module.getStudent(inEditAgeIndex).editAge(inEditAgeAge);
		} else {
			// Error message
			System.out.println("Please enter an index in the range of students.");
		}
		
	}
	
	// Remove student command method
	public void remove() {
		// View students
		module.viewStudents();
		
		// Asks for student index
		System.out.println("What is is the index of the student you want to delete? (the number displayed on the far left)");
		int inRemoveIndex = input.nextInt();
		input.nextLine();
		
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
			input.nextLine();
			
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
	
	// Edit grade command method
	public void editGrade() {
		// Views students
		module.viewStudents();
		
		// Asks for a student index
		System.out.println("What is is the index of the student you want to edit its grade? (the number displayed on the far left)");
		int inEditGradeIndex = input.nextInt();
		
		// Checks if the student index is within the right range
		if (inEditGradeIndex > -1 && inEditGradeIndex < module.getStudents().size()) {
			// Views the student's grades
			module.getStudent(inEditGradeIndex).viewGrades();
			
			// Asks for a grade index
			System.out.println("What is is the index the grade you want to edit? (the number displayed on the far left)");
			int inEditGradeGradeIndex = input.nextInt();
			
			if (inEditGradeGradeIndex > -1 && inEditGradeGradeIndex < module.getStudent(inEditGradeIndex).getGrades().size()) {
				// Asks for a grade
				System.out.println("What is the new grade you want to set that grade to? (numbers 1-9)");
				int inEditGradeGrade = input.nextInt();
				input.nextLine();
				
				// Checks if the grade is within the correct range
				if (inEditGradeGrade > 0 && inEditGradeGrade < 10) {
					// Edits the grade
					module.getStudent(inEditGradeIndex).editGrade(inEditGradeGradeIndex, inEditGradeGrade);
				} else {
					// Error message
					System.out.println("Please enter an integer between one and nine.");
				}
			} else {
				// Error message
				System.out.println("Please enter an index in the range of grades.");
			}
		} else {
			// Error message
			System.out.println("Please enter an index in the range of students.");
		}
	}
	
	// Remove grade command method
	public void removeGrade() {
		// Views students
		module.viewStudents();
		
		// Asks for a student index
		System.out.println("What is is the index of the student you want to remove a grade from? (the number displayed on the far left)");
		int inRemoveGradeIndex = input.nextInt();
		
		// Checks if the student index is within the right range
		if (inRemoveGradeIndex > -1 && inRemoveGradeIndex < module.getStudents().size()) {
			// Asks for a grade index
			System.out.println("What is is the index the grade you want to remove? (the number displayed on the far left)");
			int inRemoveGradeGradeIndex = input.nextInt();
			input.nextLine();
			
			// Checks if the grade index is within the correct range
			if (inRemoveGradeGradeIndex > -1 && inRemoveGradeGradeIndex < module.getStudent(inRemoveGradeIndex).getGrades().size()) {
				// Removes the grade
				module.getStudent(inRemoveGradeIndex).removeGrade(inRemoveGradeGradeIndex);
			} else {
				// Error message
				System.out.println("Please enter an index in the range of grades.");
			}
		} else {
			// Error message
			System.out.println("Please enter an index in the range of students.");
		}
	}
	
	// Save command method
	public void save() {
		// Save message
		System.out.println("Saved students to file.");
		
		fileData.save(module.getStudents());
	}
	
	// Load command method
	public void load() {
		// If a file is returned...
		if (fileData.load() != null) {
			// Load students
			module.setStudents(fileData.load());
			
			// Load messages
			System.out.println("Loaded students from file.");
			module.viewStudents();
		} else {
			// Error message
			System.out.println("Could not load students.");
		}
	}
	
}
