package com.velocity.quizapp.admin;

import com.velocity.quizapp.database.QuestionDatabaseImpl;
import com.velocity.quizapp.user.Question;
import com.velocity.quizapp.user.Student;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class QuestionService {
	private QuestionDatabaseImpl questionDatabaseImpl;

	public QuestionService() {
		this.questionDatabaseImpl = new QuestionDatabaseImpl();
	}

	public void displayQuestions(Scanner scanner, Student currentStudent) {
    	
        List<Question> questions = questionDatabaseImpl.findAll();
     try {
        for (Question question : questions) {
            System.out.println(question.getQuestion());
            System.out.println("1. " + question.getOption1());
            System.out.println("2. " + question.getOption2());
            System.out.println("3. " + question.getOption3());
            System.out.println("4. " + question.getOption4());
           
          
            System.out.print("Enter your answer: ");
           
            int answer =scanner.nextInt();
            scanner.nextLine();

            if (answer == question.getCorrectOption()) {
            	
                Student.setCurrentScore(Student.getCurrentScore() + 1);
            }
         
           }
        }catch (InputMismatchException e) {
        	System.out.println("Enter valid input");
        	scanner.nextLine();
        }
       }

	public void addQuestion(Scanner scanner) {
		System.out.print("Enter the question: ");
		String questionText = scanner.nextLine();
		System.out.print("Enter option 1: ");
		String option1 = scanner.nextLine();
		System.out.print("Enter option 2: ");
		String option2 = scanner.nextLine();
		System.out.print("Enter option 3: ");
		String option3 = scanner.nextLine();
		System.out.print("Enter option 4: ");
		String option4 = scanner.nextLine();
		System.out.print("Enter the correct option (1-4): ");
		int correctOption = scanner.nextInt();
		scanner.nextLine();

		Question question = new Question();
		question.setQuestion(questionText);
		question.setOption1(option1);
		question.setOption2(option2);
		question.setOption3(option3);
		question.setOption4(option4);
		question.setCorrectOption(correctOption);

		questionDatabaseImpl.save(question);
		System.out.println("Question added successfully.");
	}
}