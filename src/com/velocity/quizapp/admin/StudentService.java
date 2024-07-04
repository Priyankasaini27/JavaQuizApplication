package com.velocity.quizapp.admin;

import com.velocity.quizapp.database.StudentDatabaseImpl;
import com.velocity.quizapp.user.Student;

import java.util.Scanner;

public class StudentService {
	private StudentDatabaseImpl studentDatabaseImpl;

	public StudentService() {
		this.studentDatabaseImpl = new StudentDatabaseImpl();
	}

	public void registerStudent(Scanner scanner) {
		try {

			System.out.print("Enter the first name: ");
			String firstName = scanner.nextLine();
			System.out.print("Enter the last name: ");
			String lastName = scanner.nextLine();
			System.out.print("Enter the username: ");
			String username = scanner.nextLine();
			System.out.print("Enter the password: ");
			String password = scanner.nextLine();
			System.out.print("Enter the city: ");
			String city = scanner.nextLine();
			System.out.print("Enter the mail id: ");
			String email = scanner.nextLine();
			System.out.print("Enter the mobile number: ");
			String mobileNumber = scanner.nextLine();

			System.out.println();
			Student student = new Student();
			student.setFirstName(firstName);
			student.setLastName(lastName);
			student.setUsername(username);
			student.setPassword(password);
			student.setCity(city);
			student.setEmail(email);
			student.setMobileNumber(mobileNumber);

			studentDatabaseImpl.save(student);

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println();
	}

	public Student loginStudent(Scanner scanner) {
		System.out.print("Enter the username: ");
		String username = scanner.nextLine();
		System.out.print("Enter the password: ");
		String password = scanner.nextLine();

		System.out.println();

		Student student = studentDatabaseImpl.findByUsernameAndPassword(username, password);
		if (student != null) {
			System.out.println("Login successful.\n Welcome, " + student.getFirstName() + "!");
			System.out.println();
			return student;
		} else {
			System.out.println("Invalid username or password.");
			return null;
		}
	}
}