package com.velocity.quizapp.admin;


import com.velocity.quizapp.database.ResultDatabaseImpl;
import com.velocity.quizapp.user.Result;

import java.util.List;
import java.util.Scanner;

public class ResultService {
    private ResultDatabaseImpl resultdatabaseImpl;

    public ResultService() {
        this.resultdatabaseImpl = new ResultDatabaseImpl();
    }

    public void storeResult(Scanner scanner, int studentId, int score) {
        Result result = new Result();
        result.setStudentId(studentId);
        result.setScore(score);

        resultdatabaseImpl.save(result);
        System.out.println("Result stored successfully.");
        System.out.println();
        
    }

    public void displayResult(Scanner scanner, int studentId) {
        Result result = resultdatabaseImpl.findByStudentId(studentId);
        if (result != null) {
            System.out.println("Your score is " + result.getScore());
        } else {
            System.out.println("No result found for the given student id.");
        }
    }

    public void displayAllScores() {
    	   List<Result> results = resultdatabaseImpl.findAll();
           for (Result result : results) {
               System.out.println("Student ID: " + result.getStudentId());
               System.out.println("First Name :" +result.getFirstName());
               System.out.println("Last Name :" +result.getLastName());
               System.out.println("Score :" +result.getScore());
             
           }
    }

    public void fetchScoreById(Scanner scanner) {
        System.out.print("Enter the student id: ");
        int studentId = scanner.nextInt();
        scanner.nextLine();

        Result result = resultdatabaseImpl.findByStudentId(studentId);
        if (result != null) {
            System.out.println("Score is " + result.getScore());
        } else {
            System.out.println("No result found for the given student id.");
        }
        System.out.println();
    }
}