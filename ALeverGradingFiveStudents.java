/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package vu.main.alevergradingsystemforfivestudents;

/**
 *
 * @author Emma
 */

import java.util.Scanner;

public class ALeverGradingFiveStudents {
    
    public static void main(String[] args) {
        
        try (Scanner input = new Scanner(System.in)) {
            
            int[] gradeCount = new int[10]; // Index 1-9 for grades, 0 unused
            
            int studentCount = 0;
            
            // Process 5 students using while loop
            
            while (studentCount < 5) {
                
                System.out.print("Enter score for student " + (studentCount + 1) + " (0-100): ");
                
                int score = input.nextInt();
                
                int grade;
                
                // Determine grade
                
                if (score >= 80 && score <= 100) grade = 1;
                else if (score >= 75 && score <= 79) grade = 2;
                else if (score >= 66 && score <= 74) grade = 3;
                else if (score >= 60 && score <= 65) grade = 4;
                else if (score >= 50 && score <= 59) grade = 5;
                else if (score >= 45 && score <= 49) grade = 6;
                else if (score >= 35 && score <= 44) grade = 7;
                else if (score >= 30 && score <= 34) grade = 8;
                else if (score >= 0 && score <= 29) grade = 9;
                else {
                    
                    System.out.println("Invalid score! Please enter between 0-100.");
                    
                    continue; // Skip this iteration
                }
                
                gradeCount[grade]++;
                studentCount++;
                
                System.out.println("Student " + studentCount + " - Score: " + score + ", Grade: " + grade);
            }
            
            // Display summary
            
            System.out.println("\n--- GRADE SUMMARY ---");
            for (int i = 1; i <= 9; i++) {
                
                System.out.println("Grade " + i + ": " + gradeCount[i] + " student(s)");
            }
            
        } // Index 1-9 for grades, 0 unused
    }
}