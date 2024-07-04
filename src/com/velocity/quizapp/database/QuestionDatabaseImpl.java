package com.velocity.quizapp.database;

import com.velocity.quizapp.user.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class QuestionDatabaseImpl implements QuestionDatabase {
	
    public void save(Question question) {
        Connection connection = DatabaseConnection.getConnection();
        String sql = "INSERT INTO questions (question, option1, option2, option3, option4, correct_option) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1,question.getQuestion());
            stmt.setString(2, question.getOption1());
            stmt.setString(3, question.getOption2());
            stmt.setString(4, question.getOption3());
            stmt.setString(5, question.getOption4());
            stmt.setInt(6, question.getCorrectOption());
            stmt.executeUpdate();
        } catch (SQLException e) {
           System.out.println("Invalid input");
        }
    }

    public List<Question> findAll() {
        List<Question> questions = new ArrayList<>();
        Connection connection = DatabaseConnection.getConnection();
        String sql = "SELECT * FROM questions ORDER BY RAND( ) LIMIT 10";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Question question = new Question();
                question.setId(rs.getInt("id"));
                question.setQuestion(rs.getString("question"));
                question.setOption1(rs.getString("option1"));
                question.setOption2(rs.getString("option2"));
                question.setOption3(rs.getString("option3"));
                question.setOption4(rs.getString("option4"));
                question.setCorrectOption(rs.getInt("correct_option"));
                questions.add(question);
            }
        } catch (SQLException e) {
            System.out.println("Invalid Input");
        }
        return questions;
    }
}
