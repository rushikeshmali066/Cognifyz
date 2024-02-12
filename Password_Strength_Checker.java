package Task_02;

import java.util.Scanner;

public class Password_Strength_Checker 
{
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Password Strength Checker");
        System.out.println("-------------------------");

        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        if (isStrongPassword(password)) {
            System.out.println("Password is strong! Good job!");
        } else {
            System.out.println("Password is weak. Please consider improving it.");
        }

        scanner.close();
    }

    private static boolean isStrongPassword(String password) {
        // Check if the password meets the criteria for strength
        return isLengthValid(password) &&
               containsUppercase(password) &&
               containsLowercase(password) &&
               containsDigit(password) &&
               containsSpecialCharacter(password);
    }

    private static boolean isLengthValid(String password) {
        return password.length() >= 8;
    }

    private static boolean containsUppercase(String password) {
        return !password.equals(password.toLowerCase());
    }

    private static boolean containsLowercase(String password) {
        return !password.equals(password.toUpperCase());
    }

    private static boolean containsDigit(String password) {
        for (char c : password.toCharArray()) {
            if (Character.isDigit(c)) {
                return true;
            }
        }
        return false;
    }

    private static boolean containsSpecialCharacter(String password) {
        // Define a set of special characters
        String specialCharacters = "!@#$%^&*()-=_+[]{}|;:'\",.<>/?";

        for (char c : password.toCharArray()) {
            if (specialCharacters.contains(String.valueOf(c))) {
                return true;
            }
        }
        return false;
    }
}
