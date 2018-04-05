package co.uk.squishling.studentManager;

import java.util.ArrayList;

public class Test {
	
	private String name;
	private ArrayList<StudentGrade> studentGrades = null;
	
	public Test(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public ArrayList<StudentGrade> getStudentGrades() {
		return studentGrades;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setStudentGrades(ArrayList<StudentGrade> studentGrades) {
		this.studentGrades = studentGrades;
	}
	
	public void addStudentGrade(StudentGrade studentGrade) {
		studentGrades.add(studentGrade);
	}
	
	public void removeStudentGrade(int index) {
		studentGrades.remove(index);
	}
	
}
