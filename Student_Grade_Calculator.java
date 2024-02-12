package Task_01;

import java.util.Scanner;

public class Student_Grade_Calculator
{
	 public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);

	        System.out.println("Student Grade Calculator");
	        System.out.println("------------------------");

	        System.out.print("Enter the number of grades: ");
	        int numberOfGrades = scanner.nextInt();

	        // Check if the number of grades is valid
	        if (numberOfGrades <= 0) {
	            System.out.println("Invalid number of grades. Please enter a positive integer.");
	            return;
	        }

	        int[] grades = new int[numberOfGrades];
	        int sum = 0;

	        // Input each grade
	        for (int i = 0; i < numberOfGrades; i++) {
	            System.out.print("Enter grade #" + (i + 1) + ": ");
	            grades[i] = scanner.nextInt();

	            // Validate that the grade is within a valid range (e.g., 0-100)
	            if (grades[i] < 0 || grades[i] > 100) {
	                System.out.println("Invalid grade. Please enter a grade between 0 and 100.");
	                return;
	            }

	            sum += grades[i];
	        }

	        // Calculate the average grade
	        double average = (double) sum / numberOfGrades;

	        // Display the average grade
	        System.out.println("Average Grade: " + average);

	        scanner.close();
	    }
}
