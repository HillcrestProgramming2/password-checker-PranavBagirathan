package org.hillcrest.chapter6.password;

import java.util.Scanner;

/**
 * Main application class for checking password strength
 */
public class PasswordCheckerApp {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your password: ");
        String password = input.nextLine();

        int score = org.hillcrest.chapter6.password.CriteriaChecker.evaluateCriteria(password);
        String strength = org.hillcrest.chapter6.password.CriteriaChecker.determineStrength(score);

        System.out.println("\nPassword Strength: " + strength + " (" + score + "/5)");

        if (!strength.equals("Strong")) {
            System.out.println("Suggestions to improve your password: ");
            System.out.println(org.hillcrest.chapter6.password.FeedbackGenerator.generateFeedback(password));
        }
    }
}


