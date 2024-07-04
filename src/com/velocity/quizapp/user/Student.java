package com.velocity.quizapp.user;

public class Student {
    private int id;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String city;
    private String email;
    private String mobileNumber;
    private static Student currentStudent;
    private static int currentScore;
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public static int getCurrentScore() {
		return currentScore;
	}

	public static void setCurrentScore(int currentScore) {
		Student.currentScore = currentScore;
	}
	public static Student getCurrentStudent() {
		return currentStudent;
	}
	public static void setCurrentStudent(Student currentStudent) {
		Student.currentStudent = currentStudent;
	}

    
}
