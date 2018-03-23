package co.uk.squishling.studentManager;

import java.util.ArrayList;

public class Student {
	
	// Creates name, age and grades variables
	private String name;
	private int age;
	private ArrayList<Integer> grades = new ArrayList<Integer>();
	
	// Student constructor, takes name and age
	public Student(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	// Adds the specified grade (from 1 to 9) to the grades ArrayList
	public void addGrade(Integer grade) {
		// Adds the grade
		grades.add(grade);
	}
	
	// Gets the students grades
	public ArrayList<Integer> getGrades() {
		// Returns the grades ArrayList
		return grades;
	}
	
	// toString method that prints out information about the student
	public String toString() {
		return "Name: " + name + ", Age: " + age + ", Grades: " + grades;
	}
	
}
