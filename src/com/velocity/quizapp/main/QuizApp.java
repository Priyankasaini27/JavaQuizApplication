package com.velocity.quizapp.main;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.velocity.quizapp.admin.QuestionService;
import com.velocity.quizapp.admin.ResultService;
import com.velocity.quizapp.admin.StudentService;
import com.velocity.quizapp.user.Student;

public class QuizApp {
   
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentService studentService = new StudentService();
        QuestionService questionService = new QuestionService();
        ResultService resultService = new ResultService();
        
  try{
       while(true) {
    	   System.out.println();
    	   System.out.println("Welcome to Quiz based application");
           System.out.println();
           System.out.println("User Operation");
           System.out.println();
           System.out.println("1. Student Registration");
           System.out.println("2. Student Login");
           System.out.println("3. Display the list of questions");
           System.out.println("4. Store Quiz result into database");
           System.out.println("5. Display Quiz result");
           System.out.println();
           System.out.println("Admin Operation");
           System.out.println();
           System.out.println("6. Display all students score as per ascending order");
           System.out.println("7. Fetch student score by using id");
           System.out.println("8. Add question with 4 options into database");
           System.out.println();
           System.out.print("Enter your choice- ");
           
           int choice = scanner.nextInt();
           scanner.nextLine(); 

           switch (choice) {
               case 1:
                   studentService.registerStudent(scanner);
                   break;
               case 2:
                   Student.setCurrentStudent(studentService.loginStudent(scanner));
                   Student.setCurrentScore(0);
                   break;
               case 3:
                   if (Student.getCurrentStudent() == null) {
                       System.out.println("You must login first.");
                   } else {
                       questionService.displayQuestions(scanner, Student.getCurrentStudent());
                   }
                   break;
               case 4:
                   if (Student.getCurrentStudent() == null) {
                       System.out.println("You must login first.");
                   } else {
                       resultService.storeResult(scanner, Student.getCurrentStudent().getId(), Student.getCurrentScore());
                   }
                   break;
               case 5:
                   if (Student.getCurrentStudent() == null) {
                       System.out.println("You must login first.");
                   } else {
                       resultService.displayResult(scanner, Student.getCurrentStudent().getId());
                   }
                   break;
               case 6:
                   resultService.displayAllScores();
                   break;
               case 7:
                   resultService.fetchScoreById(scanner);
                   break;
               case 8:
                   questionService.addQuestion(scanner);
                   break;
               default:
                   System.out.println("Invalid choice. Please try again.");
           }

       }
   }catch (InputMismatchException e) {
        	System.out.println("Enter valid input");

}
}
}