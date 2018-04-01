package co.uk.squishling.studentManager;

import java.io.Serializable;
import java.util.ArrayList;

public class Student implements Serializable {
	
	// Serial id for save serialization
	private static final long serialVersionUID = -441433908272758221L;
	
	// Creates name, age and grades variables
	private String name;
	private int age;
	private ArrayList<Integer> grades = new ArrayList<Integer>();
	
	// Student constructor, takes name and age
	public Student(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	// Changes the student's name to the new specified name
	public void editName(String n) {
		name = n;
	}
	
	// Changes the student's age to the new specified age
	public void editAge(int age) {
		this.age = age;
	}
	
	// Adds the specified grade (from 1 to 9) to the grades ArrayList
	public void addGrade(int grade) {
		grades.add(grade);
	}
	
	// Changes the grade with the specified index in the grades ArrayList to the new specified grade
	public void editGrade(int index, int grade) {
		grades.set(index, grade);
	}
	
	// Removes the specified grade from the grades ArrayList
	public void removeGrade(int index) {
		grades.remove(index);
	}
	
	public float averageGrade() {
		int averageGrade = 0;
		
		// Checks if the student does in fact have grades to avoid an error from dividing by zero
		if (grades.size() > 0) {
			for (int j = 0; j < grades.size(); j++) {
				averageGrade += grades.get(j);
			}
			
			averageGrade = averageGrade / grades.size();
		}
		
		return averageGrade;
	}
	
	// Gets the student's grades
	public ArrayList<Integer> getGrades() {
		return grades;
	}
	
	// Prints out grade information
	public String viewGrades() {
		String gradesString = "Grades of " + name + ":\n";
		
		for (int i = 0; i < grades.size(); i++) {
//			System.out.println(i + " | Grade: " + grades.get(i));
			
			gradesString += i + " | Grade: " + grades.get(i) + "\n";
		}
		
		return gradesString;
	}
	
	// toString method that prints out information about the student
	public String toString() {
		return "Name: " + name + ", Age: " + age + ", Grades: " + grades;
	}
	
}
