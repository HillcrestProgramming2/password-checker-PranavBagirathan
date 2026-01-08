package org.hillcrest.chapter6.password;

/**
 * Utility class for evaluating password strength based on 5 criteria
 */
public class CriteriaChecker {
    /**
     * Evaluates the password and returns how many criteria it meets
     * @param password - the password that the user inputs
     * @return the criteria that the password meets
     */
    public static int evaluateCriteria(String password){
        int score = 0;

        //Criterion 1: Password length is at least 8 characters
        if (password.length() >= 8) {
            score++;
        }

        boolean hasUpper = false;
        boolean hasLower = false;
        boolean hasDigit = false;
        boolean hasSpecial = false;

        String specialChar = "!@#$%^&*()-+=";

        //Loop through characters
        for (int i = 0; i < password.length(); i++) {
            char ch = password.charAt(i);
            if (Character.isUpperCase(ch)) {
                hasUpper = true;
            }
            if (Character.isLowerCase(ch)) {
                hasLower = true;
            }
            if (Character.isDigit(ch)) {
                hasDigit = true;
            }
            if (specialChar.indexOf(ch) != -1) {
                hasSpecial = true;
            }
        }

        if (hasUpper)
            score++;
        if (hasLower)
            score++;
        if (hasDigit)
            score++;
        if (hasSpecial)
            score++;

        return score;
    }

    /**
     * Returns the strength level based on score
     * @param score - the rating that determines how strong the password is
     * @return the strength level
     */
    public static String determineStrength(int score) {
        if (score <= 2) {
            return "Weak";
        } else if (score == 3) {
            return "Moderate";
        } else {
            return "Strong";
        }
    }
}