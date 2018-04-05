package co.uk.squishling.studentManager;

import java.util.ArrayList;

public class Module {
	
	private String name;
	private Teacher teacher;
	private StudentList students = null;
	private ArrayList<Test> tests = null;
	
	public Module(String name, Teacher teacher) {
		this.name = name;
		this.teacher = teacher;
	}
	
	public String getName() {
		return name;
	}
	
	public Teacher getTeacher() {
		return teacher;
	}
	
	public StudentList getStudents() {
		return students;
	}
	
	public ArrayList<Test> getTests() {
		return tests;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	
	public void setStudents(StudentList students) {
		this.students = students;
	}
	
	public void setTests(ArrayList<Test> tests) {
		this.tests = tests;
	}
	
	public void addStudent(Student student) {
		students.add(student);
	}
	
	public void removeStudent(int index) {
		students.remove(index);
	}
	
	public void addTest(Test test) {
		tests.add(test);
	}
	
	public void removeTest(int index) {
		tests.remove(index);
	}
	
}
