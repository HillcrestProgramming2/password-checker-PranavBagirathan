package org.hillcrest.chapter6.password;

import java.util.Scanner;

public class PasswordCheckerApp {
    //main method goes here
    //prompt user for password
    //Check strength
    //Provide user feedback based on the strength
    import java.util.Scanner;

    public class PasswordApp {
        public static void main(String[] args) {
            Scanner input = new Scanner(System.in);
            System.out.print("Enter your password: ");
            String password = input.nextLine();

            int score = CriteriaChecker.evaluateCriteria(password);
            String strength = CriteriaChecker.determineStrength(score);

            System.out.println("\nPassword Strength: " + strength + " (" + score + "/5)");

            if (!strength.equals("Strong")) {
                System.out.println("Suggestions to improve your password: ");
                System.out.println(FeedbackGenerator.generateFeedback(password));
            }
        }
    }

}
