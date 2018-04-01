package co.uk.squishling.studentManager;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
	
}
