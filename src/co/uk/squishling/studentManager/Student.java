package co.uk.squishling.studentManager;

import java.io.Serializable;
import java.util.ArrayList;

public class Student implements Serializable {
	
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
	
	// Adds the specified grade (from 1 to 9) to the grades ArrayList
	public void addGrade(Integer grade) {
		grades.add(grade);
	}
	
	// Gets the student's grades
	public ArrayList<Integer> getGrades() {
		return grades;
	}
	
	// toString method that prints out information about the student
	public String toString() {
		return "Name: " + name + ", Age: " + age + ", Grades: " + grades;
	}
	
}
