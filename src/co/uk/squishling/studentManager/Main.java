package co.uk.squishling.studentManager;

import java.io.File;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
	
	// StudentList
	private static StudentList students = new StudentList();
	
	// FileData static object
	private static FileData fileData = new FileData();
	
	// Main method
	public static void main(String[] args) {
		// Call interaction loop method
		interact();
	}
	
	// Is integer testing method
	public static boolean isInt(String str) {
		try{
			// Try...
			Integer.parseInt(str);
			
			// If no error, progress and return true, the string must also be an int
			return true;
		} catch (NumberFormatException e) {
			// If error, the string is not an int
			return false;
		}
	}
	
	// Variable
	static Scanner input = new Scanner(System.in);
	
	// Main interaction loop method
	public static void interact() {
		while (true) {
			// Asks for command
			System.out.println("Please specify an action.\nsave | load | load_csv | view | add | remove | edit_name | edit_age | add_grade | edit_grade | remove_grade | best | sort");
			String in = input.nextLine();
					
			// If save...
			if (in.equals("save")) {
				save();
			}
			
			// If load...
			if (in.equals("load")) {
				load();
			}
			
			// If load_csv...
			if (in.equals("load_csv")) {
				loadCSV();
			}
			
			// If view...
			if (in.equals("view")) {
				System.out.println(students);
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
				System.out.println(students.best());
			}
			
			// If sort...
			if (in.equals("sort")) {
				sort();
			}
		}
	}
	
	// Add student command method
	public static void add() {
		// Asks for name
		System.out.println("What is the name of the new student?");
		String inAddName = input.nextLine();
		
		// Asks for age
		System.out.println("How old is " + inAddName + "?");
		int inAddAge = input.nextInt();
		input.nextLine();
		
		// Adds student and views all students
		students.add(inAddName, inAddAge);
		System.out.println(students);
	}
	
	// Sort student command method
	public static void sort() {
		// Asks for mode
		System.out.println("Do you want to sort students by their names (1) or their average grades (2)?");
		int mode = input.nextInt();
		input.nextLine();
		
		// Sorts, and if sorting returned false (the integer was not a 1 or a 2) display error message
		if (students.sort(mode - 1) == false) {
			System.out.println("Please enter an integer that is either 1 or 2.");
		} else {
			System.out.println("Sorted students.");
			System.out.println(students);
		}
	}
	
	// Edit name command method
	public static void editNameCmd() {
		// Views students
		System.out.println(students);
		
		// Asks for a student index
		System.out.println("What is the index of the student whoose name you want to edit? (the number displayed on the far left)");
		int inEditNameIndex = input.nextInt();
		input.nextLine();
		
		// Checks if the index is in the correct range
		if (inEditNameIndex > -1 && inEditNameIndex < students.size()) {
			// Asks for a new name
			System.out.println("What do you want its name to be?");
			String inEditNameName = input.nextLine();
			
			// Changes the name
			students.get(inEditNameIndex).editName(inEditNameName);
			System.out.println(students);
		} else {
			// Error message
			System.out.println("Please enter an index in the range of students.");
		}
		
	}
	
	// Edit age command method
	public static void editAge() {
		// Views students
		System.out.println(students);
		
		// Asks for a student index
		System.out.println("What is is the index of the student you want to edit its age? (the number displayed on the far left)");
		int inEditAgeIndex = input.nextInt();
		
		// Checks if the index is in the correct range
		if (inEditAgeIndex > -1 && inEditAgeIndex < students.size()) {
			// Asks for a new age
			System.out.println("What do you want its age to be?");
			int inEditAgeAge = input.nextInt();
			input.nextLine();
			
			// Changes the age
			students.get(inEditAgeIndex).editAge(inEditAgeAge);
			System.out.println(students);
		} else {
			// Error message
			System.out.println("Please enter an index in the range of students.");
		}
		
	}
	
	// Remove student command method
	public static void remove() {
		// View students
		System.out.println(students);
		
		// Asks for student index
		System.out.println("What is is the index of the student you want to delete? (the number displayed on the far left)");
		int inRemoveIndex = input.nextInt();
		input.nextLine();
		
		// Checks if the index is in the correct range
		if (inRemoveIndex > -1 && inRemoveIndex < students.size()) {
			// Removes the student
			students.remove(inRemoveIndex);
			System.out.println(students);
		} else {
			// Error message
			System.out.println("Please enter an index in the range of students.");
		}
	}
	
	// Add grade command method
	public static void addGrade() {
		// Views students
		System.out.println(students);
		
		// Asks for a student index
		System.out.println("What is is the index of the student you want to add a grade to? (the number displayed on the far left)");
		int inAddGradeIndex = input.nextInt();
		
		// Checks if the student index is within the right range
		if (inAddGradeIndex > -1 && inAddGradeIndex < students.size()) {
			// Asks for a grade
			System.out.println("What grade do you want to add to that student? (numbers 1-9)");
			int inAddGradeGrade = input.nextInt();
			input.nextLine();
			
			// Checks if the grade is within the correct range
			if (inAddGradeGrade > 0 && inAddGradeGrade < 10) {
				// Adds the grade
				students.get(inAddGradeIndex).addGrade(inAddGradeGrade);
				System.out.println(students);
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
	public static void editGrade() {
		// Views students
		System.out.println(students);
		
		// Asks for a student index
		System.out.println("What is is the index of the student you want to edit its grade? (the number displayed on the far left)");
		int inEditGradeIndex = input.nextInt();
		
		// Checks if the student index is within the right range
		if (inEditGradeIndex > -1 && inEditGradeIndex < students.size()) {
			// Views the student's grades
			System.out.println(students.get(inEditGradeIndex).viewGrades());
			
			// Asks for a grade index
			System.out.println("What is is the index the grade you want to edit? (the number displayed on the far left)");
			int inEditGradeGradeIndex = input.nextInt();
			
			if (inEditGradeGradeIndex > -1 && inEditGradeGradeIndex < students.get(inEditGradeIndex).getGrades().size()) {
				// Asks for a grade
				System.out.println("What is the new grade you want to set that grade to? (numbers 1-9)");
				int inEditGradeGrade = input.nextInt();
				input.nextLine();
				
				// Checks if the grade is within the correct range
				if (inEditGradeGrade > 0 && inEditGradeGrade < 10) {
					// Edits the grade
					students.get(inEditGradeIndex).editGrade(inEditGradeGradeIndex, inEditGradeGrade);
					System.out.println(students);
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
	public static void removeGrade() {
		// Views students
		System.out.println(students);
		
		// Asks for a student index
		System.out.println("What is is the index of the student you want to remove a grade from? (the number displayed on the far left)");
		int inRemoveGradeIndex = input.nextInt();
		
		// Checks if the student index is within the right range
		if (inRemoveGradeIndex > -1 && inRemoveGradeIndex < students.size()) {
			// Views the student's grades
			System.out.println(students.get(inRemoveGradeIndex).viewGrades());
			
			// Asks for a grade index
			System.out.println("What is is the index the grade you want to remove? (the number displayed on the far left)");
			int inRemoveGradeGradeIndex = input.nextInt();
			input.nextLine();
			
			// Checks if the grade index is within the correct range
			if (inRemoveGradeGradeIndex > -1 && inRemoveGradeGradeIndex < students.get(inRemoveGradeIndex).getGrades().size()) {
				// Removes the grade
				students.get(inRemoveGradeIndex).removeGrade(inRemoveGradeGradeIndex);
				System.out.println(students);
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
	public static void save() {
		// Save message
		System.out.println("Saved students to file.");
		
		fileData.save(students);
	}
	
	// Load command method
	public static void load() {
		// If a file is returned...
		if (fileData.load() != null) {
			// Load students
			students = fileData.load();
			
			// Load messages
			System.out.println("Loaded students from file.");
			System.out.println(students);
		} else {
			// Error message
			System.out.println("Could not load students.");
		}
	}
	
	// Load CSV file command method
	public static void loadCSV() {
		// Asks for the name of the CSV file
		System.out.println("What is the name of the CSV file you want to load? (If this is run from a jar file, make sure the csv file is in the folder the jar file is in, but if this is run from eclipse, make sure it is in the bin folder of this eclipse project).");
		String fileName = input.nextLine();
		
		// In case the code is run from a jar file, this will get the FileData class (you can't use getClass() on Main), and get its location directory, convert it to a string, replace file:/ (for some reason it is added, and gives an error), and replace %20 with a space (%20 means space, but if you try to use the path with %20 instead of an actual space, it doesn't work).
		String directory = fileData.getClass().getProtectionDomain().getCodeSource().getLocation().toString().replaceAll("file:/", "").replaceAll("%20", " ");
		
		// Temporary StudentList
		StudentList newStudents = fileData.loadCSV(directory + fileName);
		
		// If there were no problems...
		if (newStudents != null) {
			// Set students to the new StudentList
			students = newStudents;
			
			// Loaded message
			System.out.println("Loaded students from file.");
			System.out.println(students);
		} else {
			// If error...
			System.out.println("An error occurred while trying to load CSV file " + directory + fileName + ".  Are you sure you used the right file name, and if so, that it is in the correct place?");
		}
	}
		
}
