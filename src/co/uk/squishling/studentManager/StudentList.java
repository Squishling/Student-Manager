package co.uk.squishling.studentManager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

import co.uk.squishling.studentManager.Student;

public class StudentList extends ArrayList<Student> {

	private static final long serialVersionUID = 796025135626555452L;
	
	// Adds a student with the specified name and age
	public void add(String name, int age) {
		add(new Student(name, age));
	}
	
	// Sorts the students by either name or average grade
	public boolean sort(int mode) {
		// If the mode is correct...
		if (!(mode > 1) || !(mode < 0)) {
			// Sort by name
			if (mode == 0) {
				sort(Comparator.comparing(Student::getName, String.CASE_INSENSITIVE_ORDER));
			}
			
			// Sort by age
			if (mode == 1) {
				sort(Comparator.comparing(Student::averageGrade).reversed());
			}
			
			// No error
			return true;
		}
		
		// Error
		return false;
	}
	
	// Works out the best student (probably isn't the most efficient)
	public Student best() {
		// Variables
		float currentBest = 0;
		Student currentBestStudent = null;
		
		for (int i = 0; i < size(); i++) {
			// Variables
			Student student = get(i);
			ArrayList<Integer> grades = student.getGrades();
			float averageGrade = student.averageGrade();
			
			// Checks if the current student's average grade is better than the current best
			if (averageGrade > currentBest) {
				// If so, it sets the current best grade to the average grade of the current student and sets the current best student to the current student
				currentBest = averageGrade;
				currentBestStudent = student;
			}
		}
		
		// Returns the now best student
		return currentBestStudent;
	}
	
	// To string that views students, with their index, and other details specified in the Student class
	public String toString() {			
		// Message if there are no students so that a user doesn't wonder why nothing happened when they viewed all of the students
		if (size() == 0) {
			return "There are currently no students to view at this time.";
		} else {
			String viewString = "";
			
			// Loops
			for (int i = 0; i < size(); i++) {
				// Prints information
				viewString += i + " | " + get(i) + "\n";
			}
			
			// Take newline off end
			viewString = viewString.trim();
			
			// Return
			return viewString;
		}
	}
	
}
