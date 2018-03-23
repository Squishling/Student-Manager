package co.uk.squishling.studentManager;

import java.util.ArrayList;

public class Module {
	
	// Create an ArrayList of type Student
	private ArrayList<Student> students = new ArrayList<Student>();
	
	// Adds a student with the specified name and age to the students ArrayList
	public void addStudent(String name, int age) {
		// Adds the student
		students.add(new Student(name, age));
	}
	
	// Removes a student with the specified index within the students ArrayList
	public void removeStudent(int index) {
		// Removes the student
		students.remove(index);
	}
	
	// Returns the student with the specified index within the students ArrayList
	public Student getStudent(int index) {
		// Gets the student
		return students.get(index);
	}
	
	// Returns the students ArrayList
	public ArrayList<Student> getStudents() {
		// Returns students
		return students;
	}
	
	// Views students in the students ArrayList, with their index, and other details specified in the Student class
	public void viewStudents() {
		// Loops through students
		for (int i = 0; i < students.size(); i++) {
			// Prints information
			System.out.println(i + " | " + students.get(i));
		}
	}
	
	// Works out the best student (probably isn't the most efficient)
	public Student bestStudent() {
		// Sets up current best variables
		int currentBest = 0;
		Student currentBestStudent = null;
		
		// Loops through all students
		for (int i = 0; i < students.size(); i++) {
			// Sets up variables for student
			Student student = students.get(i);
			ArrayList<Integer> grades = student.getGrades();
			int averageGrade = 0;
			
			// Checks if the student does in fact have grades to avoid an error from dividing by zero
			if (grades.size() > 0) {
				// Loops through the current student's grades
				for (int j = 0; j < grades.size(); j++) {
					// Adds the current grade to the average
					averageGrade += grades.get(j);
				}
				
				// Divides the average by how many grades there are (works out the mean)
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
