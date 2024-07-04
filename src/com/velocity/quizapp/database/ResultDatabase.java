package com.velocity.quizapp.database;

import java.util.List;

import com.velocity.quizapp.user.Result;

public interface ResultDatabase {
    
	public void save(Result result);
	 public Result findByStudentId(int studentId);
	 public List<Result> findAll() ;
}
