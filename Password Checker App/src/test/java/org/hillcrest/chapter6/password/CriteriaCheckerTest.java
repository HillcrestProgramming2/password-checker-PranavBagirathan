package org.hillcrest.chapter6.password;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Tests for correct strength level per missing criteria of the password
 */
public class CriteriaCheckerTest {
    /**
     * Tests for weak password
     */
    @Test
    public void testConstruct_weakPasswordShouldBeSet() {
        Assertions.assertEquals(1, CriteriaChecker.evaluateCriteria("12345"));
        Assertions.assertEquals("Weak", CriteriaChecker.determineStrength(1));
    }

    /**
     * Tests for moderate password
     */
    @Test
    public void testConstruct_moderatePasswordShouldBeSet() {
        Assertions.assertEquals(3, CriteriaChecker.evaluateCriteria("password123"));
        Assertions.assertEquals("Moderate", CriteriaChecker.determineStrength(3));
    }

    /**
     * Tests for strong password
     */
    @Test
    public void testConstruct_strongPasswordShouldBeSet() {
        Assertions.assertEquals(5, CriteriaChecker.evaluateCriteria("Secure@2024"));
        Assertions.assertEquals("Strong", CriteriaChecker.determineStrength(5));
    }

    /**
     * Tests for password meeting no criteria
     */
    @Test
    public void testConstruct_noCriteriaMet() {
        Assertions.assertEquals(0, CriteriaChecker.evaluateCriteria(""));
        Assertions.assertEquals("Weak", CriteriaChecker.determineStrength(0));
    }

    /**
     * Tests for password that is fully uppercase
     */
    @Test
    public void testConstruct_onlyUppercase() {
        Assertions.assertEquals(1, CriteriaChecker.evaluateCriteria("ABCD"));
        Assertions.assertEquals("Weak", CriteriaChecker.determineStrength(1));
    }
}
