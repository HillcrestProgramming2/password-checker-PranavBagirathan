package org.hillcrest.chapter6.password;

public class FeedbackGenerator {
    //utility class for generating feedback based on password
    public class FeedbackGenerator {
        public static String generateFeedback(String password){
            String feedback = "";

            if (password.length() < 8) {
                feedback += "* Increase the length to at least 8 characters.\n";
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

            if (!hasUpper) {
                feedback += "* Add at least one uppercase letter.\n";
            }
            if (!hasLower) {
                feedback += "* Add at least one lower case letter.\n";
            }
            if (!hasDigit) {
                feedback += "* Add at least one number.\n";
            }
            if (!hasSpecial) {
                feedback += "* Include at least one special character.\n";
            }

            if (feedback.equals("")) {
                return "Your password successfully met all of the criteria.";
            }

            return feedback;
        }
    }
}
