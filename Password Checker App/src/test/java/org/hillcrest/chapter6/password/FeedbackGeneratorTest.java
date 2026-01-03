package org.hillcrest.chapter6.password;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FeedbackGeneratorTest {
    @Test
    public void testConstruct_weakPasswordFeedbackSet() {
        String fb = FeedbackGenerator.generateFeedback("123ez");
        Assertions.assertTrue(fb.contains("Increase the length"));
        Assertions.assertTrue(fb.contains("uppercase"));
    }

    @Test
    public void testConstruct_moderatePasswordFeedbackSet() {
        String fb = FeedbackGenerator.generateFeedback("longpass257");
        Assertions.assertTrue(fb.contains("uppercase"));
    }

    @Test
    public void testConstruct_strongPasswordFeedbackSet() {
        String fb = FeedbackGenerator.generateFeedback("Password@Secure26");
        Assertions.assertEquals("Your password successfully met all of the criteria.", fb);
    }

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
