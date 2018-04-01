package co.uk.squishling.studentManager;

import java.util.ArrayList;

import co.uk.squishling.studentManager.Student;

public class StudentList extends ArrayList<Student> {

	private static final long serialVersionUID = 796025135626555452L;
	
	// Adds a student with the specified name and age to the students ArrayList
		public void add(String name, int age) {
			add(new Student(name, age));
		}
		
		// Views students in the students ArrayList, with their index, and other details specified in the Student class
		public String view() {			
			// Message if there are no students so that a user doesn't wonder why nothing happened when they viewed all of the students
			if (size() == 0) {
				return "There are currently no students to view at this time.";
			} else {
				String viewString = "";
				
				for (int i = 0; i < size(); i++) {
					// Prints information
					viewString += i + " | " + get(i) + "\n";
				}
				
				return viewString;
			}
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
	
}
