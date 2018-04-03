package co.uk.squishling.studentManager;

import java.util.List;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class FileData {
	
	// Save students to a file
	public void save(StudentList students) {
		// Try/catch in case of errors (suggested by Eclipse)
		try {
			// Creating file out and object out
			FileOutputStream fileOut = new FileOutputStream("students");
			ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
			// Writing students to object out, and closing object out
			objectOut.writeObject(students);
			objectOut.close();
		} catch (Exception e) {
			// Error
			e.printStackTrace();
		}
	}
	
	// Load students from file
	public StudentList load() {
		// Try/catch in case of errors (suggested by Eclipse)
		try {
			// Tests if the students file exists
			File studentsFile = new File("students");
			if (studentsFile.exists() && !studentsFile.isDirectory()) {
				// Creating file in and object in
				FileInputStream fileIn = new FileInputStream("students");
				ObjectInputStream objectIn = new ObjectInputStream(fileIn);
				// Creating students ArrayList from object in and closing object in
				StudentList students = (StudentList) objectIn.readObject();
				objectIn.close();
				
				// Returning students ArrayList
				return students;
			}
		} catch (Exception e) {
			// Error
			e.printStackTrace();
		}
		
		// If nothing was loaded, return null
		return null;
	}
	
	// Load students from CSV file
	public StudentList loadCSV(String path) {
		// Variables
		StudentList studentList = new StudentList();
		Path studentsFile = Paths.get(path);
		
		// If the file exists
		if (Files.exists(studentsFile)) {
			// Make a lines list
			List<String> lines = null;
			
			try {
				// Set it to the liens in the CSV file
				lines = Files.readAllLines(studentsFile, Charset.defaultCharset());
			} catch (IOException e) {
				// Return null (means there was an error)
				return null;
			}
			
			// StudentList
			StudentList students = new StudentList();
			
			// Loop through all lines except first line (for headings)
			for (int i = 1; i < lines.size(); i++) {
				// Variables
				String[] values = lines.get(i).split(",");
				String name = values[0];
				int age;
				Student student;
				
				// If age exists...
				if (values[1] != null && Main.isInt(values[1])) {
					// Set age
					age = Integer.parseInt(values[1]);
					
					// Make new student
					student = new Student(name, age);
					
					// Loop through the rest of the values
					for (int j = 2; j < values.length; j++) {
						// Test if it is a valid grade
						if (Main.isInt(values[j]) && Integer.parseInt(values[j]) > 0 && Integer.parseInt(values[j]) < 10) {
							// Adds the grade
							student.addGrade(Integer.parseInt(values[j]));
						}
					}
					
					// Adds the student to the list
					students.add(student);
				}
			}
			
			// Returns the StudentList
			return students;
		}
		
		// Error
		return null;
	}
	
}
