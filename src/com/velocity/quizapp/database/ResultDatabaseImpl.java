package com.velocity.quizapp.database;

import com.velocity.quizapp.user.Result;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ResultDatabaseImpl implements ResultDatabase {

	@Override
	public void save(Result result) {
		Connection connection = DatabaseConnection.getConnection();
		String sql = "INSERT INTO results (student_id, score) VALUES (?, ?)";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setInt(1, result.getStudentId());
			stmt.setInt(2, result.getScore());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Result findByStudentId(int studentId) {
		Connection connection = DatabaseConnection.getConnection();
		String sql = "SELECT * FROM results WHERE student_id = ?";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setInt(1, studentId);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				Result result = new Result();
				result.setStudentId(rs.getInt("student_id"));
				result.setScore(rs.getInt("score"));
				return result;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Result> findAll() {
		  List<Result> results = new ArrayList<>();
	        Connection connection = DatabaseConnection.getConnection();
	        String sql = "SELECT students.id, students.first_name, students.last_name, students.username, results.score FROM students JOIN results ON students.id = results.student_id";
	        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
	            ResultSet rs = stmt.executeQuery();
	            while (rs.next()) {
	                Result result = new Result();
	                result.setStudentId(rs.getInt("id"));
	                result.setFirstName(rs.getString("first_name"));
	                result.setLastName(rs.getString("last_name"));
	                result.setUsername(rs.getString("username"));
	                result.setScore(rs.getInt("score"));
	                results.add(result);
	            }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return results;
	}
}
