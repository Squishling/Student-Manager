package co.uk.squishling.studentManager;

public class StudentGrade {
	
	private int grade;
	private String comment;
	private Student student;
	
	public StudentGrade(int grade, String comment, Student student) {
		this.grade = grade;
		this.comment = comment;
		this.student = student;
	}
	
	public int getGrade() {
		return grade;
	}
	
	public String getComment() {
		return comment;
	}
	
	public Student getStudent() {
		return student;
	}
	
	public void setGrade(int grade) {
		this.grade = grade;
	}
	
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	public void setStudent(Student student) {
		this.student = student;
	}
	
}
