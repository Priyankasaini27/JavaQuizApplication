package com.velocity.quizapp.database;



import java.util.List;

import com.velocity.quizapp.user.Student;

public interface StudentDatabase {
	
	 public void save(Student student) ;
	  public Student findByUsernameAndPassword(String username, String password);
	
	  public List<Student> findAll();

}
