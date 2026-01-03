package org.hillcrest.chapter6.password;

public class CriteriaChecker {
    public class CriteriaChecker {
        public static int evaluateCriteria(String password){
            int score = 0;

            if (password.length() >= 8) {
                score++;
            }

            boolean hasUpper = false;
            boolean hasLower = false;
            boolean hasDigit = false;
            boolean hasSpecial = false;

            String specialChar = "!@#$%^&*()-+=";

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
}
