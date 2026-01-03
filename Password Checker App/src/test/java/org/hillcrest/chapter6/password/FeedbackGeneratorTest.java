package org.hillcrest.chapter6.password;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for correct feedback generation based on the score
 * given to the password
 */
public class FeedbackGeneratorTest {
    /**
     * Tests for correct feedback given to weak password
     */
    @Test
    public void testConstruct_weakPasswordFeedbackSet() {
        String fb = FeedbackGenerator.generateFeedback("123ez");
        Assertions.assertTrue(fb.contains("Increase the length"));
        Assertions.assertTrue(fb.contains("uppercase"));
    }

    /**
     * Tests for correct feedback given to moderate password
     */
    @Test
    public void testConstruct_moderatePasswordFeedbackSet() {
        String fb = FeedbackGenerator.generateFeedback("longpass257");
        Assertions.assertTrue(fb.contains("uppercase"));
    }

    /**
     * Tests for correct feedback given to strong password
     */
    @Test
    public void testConstruct_strongPasswordFeedbackSet() {
        String fb = FeedbackGenerator.generateFeedback("Password@Secure26");
        Assertions.assertEquals("Your password successfully met all of the criteria.", fb);
    }

    /**
     * Tests for correct feedback given to an empty password (no criteria met)
     */
    @Test
    public void testConstruct_emptyPasswordFeedbackSet() {
        String fb = FeedbackGenerator.generateFeedback("");

        Assertions.assertTrue(fb.contains("Increase the length"));
        Assertions.assertTrue(fb.contains("uppercase"));
        Assertions.assertTrue(fb.contains("lowercase"));
        Assertions.assertTrue(fb.contains("number"));
        Assertions.assertTrue(fb.contains("special character"));
    }
}
