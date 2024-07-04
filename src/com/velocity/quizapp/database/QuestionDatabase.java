package com.velocity.quizapp.database;

import java.util.List;

import com.velocity.quizapp.user.Question;

public interface QuestionDatabase {
    
	public void save(Question question);
	public List<Question> findAll();
}
