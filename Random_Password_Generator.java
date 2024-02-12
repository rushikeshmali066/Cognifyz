package Task_01;

import java.security.SecureRandom;
import java.util.Scanner;

public class Random_Password_Generator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the desired length of the password: ");
        int passwordLength = scanner.nextInt();

        System.out.print("Include numbers? (yes/no): ");
        boolean includeNumbers = scanner.next().equalsIgnoreCase("yes");

        System.out.print("Include lowercase letters? (yes/no): ");
        boolean includeLowercase = scanner.next().equalsIgnoreCase("yes");

        System.out.print("Include uppercase letters? (yes/no): ");
        boolean includeUppercase = scanner.next().equalsIgnoreCase("yes");

        System.out.print("Include special characters? (yes/no): ");
        boolean includeSpecialCharacters = scanner.next().equalsIgnoreCase("yes");

        String generatedPassword = generateRandomPassword(passwordLength, includeNumbers, includeLowercase, includeUppercase, includeSpecialCharacters);

        System.out.println("Generated Password: " + generatedPassword);

        scanner.close();
    }

    private static String generateRandomPassword(int length, boolean includeNumbers, boolean includeLowercase, boolean includeUppercase, boolean includeSpecialCharacters) {
        SecureRandom random = new SecureRandom();
        StringBuilder password = new StringBuilder();

        String numbers = "0123456789";
        String lowercase = "abcdefghijklmnopqrstuvwxyz";
        String uppercase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String specialCharacters = "!@#$%^&*()-_=+[]{}|;:'\",.<>/?";

        String allowedCharacters = "";

        if (includeNumbers) {
            allowedCharacters += numbers;
        }
        if (includeLowercase) {
            allowedCharacters += lowercase;
        }
        if (includeUppercase) {
            allowedCharacters += uppercase;
        }
        if (includeSpecialCharacters) {
            allowedCharacters += specialCharacters;
        }

        if (allowedCharacters.isEmpty()) {
            System.out.println("Error: At least one character type should be selected.");
            return "";
        }

        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(allowedCharacters.length());
            char randomChar = allowedCharacters.charAt(randomIndex);
            password.append(randomChar);
        }

        return password.toString();
    }
}
