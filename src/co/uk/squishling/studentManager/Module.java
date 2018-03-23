package co.uk.squishling.studentManager;

import java.util.ArrayList;

public class Module {
	
	// Variable
	private ArrayList<Student> students = new ArrayList<Student>();
	
	// Adds a student with the specified name and age to the students ArrayList
	public void addStudent(String name, int age) {
		students.add(new Student(name, age));
	}
	
	// Removes a student with the specified index within the students ArrayList
	public void removeStudent(int index) {
		students.remove(index);
	}
	
	// Returns the student with the specified index within the students ArrayList
	public Student getStudent(int index) {
		return students.get(index);
	}
	
	// Returns the students ArrayList
	public ArrayList<Student> getStudents() {
		return students;
	}
	
	// Views students in the students ArrayList, with their index, and other details specified in the Student class
	public void viewStudents() {
		// Message if there are no students so that a user doesn't wonder why nothing happened when they viewed all of the students
		if (students.size() == 0) {
			System.out.println("There are currently no students to view at this time.");
		} else {
			for (int i = 0; i < students.size(); i++) {
				// Prints information
				System.out.println(i + " | " + students.get(i));
			}
		}
	}
	
	// Works out the best student (probably isn't the most efficient)
	public Student bestStudent() {
		// Variables
		int currentBest = 0;
		Student currentBestStudent = null;
		
		for (int i = 0; i < students.size(); i++) {
			// Variables
			Student student = students.get(i);
			ArrayList<Integer> grades = student.getGrades();
			int averageGrade = 0;
			
			// Checks if the student does in fact have grades to avoid an error from dividing by zero
			if (grades.size() > 0) {
				for (int j = 0; j < grades.size(); j++) {
					averageGrade += grades.get(j);
				}
				
				averageGrade = averageGrade / grades.size();
				// Checks if the current student's average grade is better than the current best
				if (averageGrade > currentBest) {
					// If so, it sets the current best grade to the average grade of the current student and sets the current best student to the current student
					currentBest = averageGrade;
					currentBestStudent = student;
				}
			}
		}
		
		// Returns the now best student
		return currentBestStudent;
	}
}
