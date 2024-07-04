package com.velocity.quizapp.database;

import com.velocity.quizapp.user.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDatabaseImpl implements StudentDatabase {
	
	@Override
    public void save(Student student) {
        Connection connection = DatabaseConnection.getConnection();
        String sql = "INSERT INTO students (first_name, last_name, username, password, city, email, mobile_number) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, student.getFirstName());
            stmt.setString(2, student.getLastName());
            stmt.setString(3, student.getUsername());
            stmt.setString(4, student.getPassword());
            stmt.setString(5, student.getCity());
            stmt.setString(6, student.getEmail());
            stmt.setString(7, student.getMobileNumber());
            stmt.executeUpdate();
            System.out.println("Student registered successfully.");
            
        } catch (SQLException e) {
        	System.out.println("  Username Already Existed \nPlease enter a different Username");
        }
    }

	@Override
    public Student findByUsernameAndPassword(String username, String password) {
        Connection connection = DatabaseConnection.getConnection();
        String sql = "SELECT * FROM students WHERE username = ? AND password = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Student student = new Student();
                student.setId(rs.getInt("id"));
                student.setFirstName(rs.getString("first_name"));
                student.setLastName(rs.getString("last_name"));
                student.setUsername(rs.getString("username"));
                student.setPassword(rs.getString("password"));
                student.setCity(rs.getString("city"));
                student.setEmail(rs.getString("email"));
                student.setMobileNumber(rs.getString("mobile_number"));
                return student;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
   
	@Override
    public List<Student> findAll() {
        List<Student> students = new ArrayList<>();
        Connection connection = DatabaseConnection.getConnection();
        String sql = "SELECT * FROM students";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Student student = new Student();
                student.setId(rs.getInt("id"));
                student.setFirstName(rs.getString("first_name"));
                student.setLastName(rs.getString("last_name"));
                student.setUsername(rs.getString("username"));
                student.setPassword(rs.getString("password"));
                student.setCity(rs.getString("city"));
                student.setEmail(rs.getString("email"));
                student.setMobileNumber(rs.getString("mobile_number"));
                students.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }
}