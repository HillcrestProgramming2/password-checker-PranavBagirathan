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
    public void test_weakPasswordShouldBeSet() {
        Assertions.assertEquals(1, org.hillcrest.chapter6.password.CriteriaChecker.evaluateCriteria("12345"));
        Assertions.assertEquals("Weak", org.hillcrest.chapter6.password.CriteriaChecker.determineStrength(1));
    }

    /**
     * Tests for moderate password
     */
    @Test
    public void test_moderatePasswordShouldBeSet() {
        Assertions.assertEquals(3, org.hillcrest.chapter6.password.CriteriaChecker.evaluateCriteria("password123"));
        Assertions.assertEquals("Moderate", org.hillcrest.chapter6.password.CriteriaChecker.determineStrength(3));
    }

    /**
     * Tests for strong password
     */
    @Test
    public void test_strongPasswordShouldBeSet() {
        Assertions.assertEquals(5, org.hillcrest.chapter6.password.CriteriaChecker.evaluateCriteria("Secure@2024"));
        Assertions.assertEquals("Strong", org.hillcrest.chapter6.password.CriteriaChecker.determineStrength(5));
    }

    /**
     * Tests for password meeting no criteria
     */
    @Test
    public void test_noCriteriaMet() {
        Assertions.assertEquals(0, org.hillcrest.chapter6.password.CriteriaChecker.evaluateCriteria(""));
        Assertions.assertEquals("Weak", org.hillcrest.chapter6.password.CriteriaChecker.determineStrength(0));
    }

    /**
     * Tests for password that is fully uppercase
     */
    @Test
    public void test_Twocase() {
        Assertions.assertEquals(2, org.hillcrest.chapter6.password.CriteriaChecker.evaluateCriteria("ABCDe"));
        Assertions.assertEquals("Weak", org.hillcrest.chapter6.password.CriteriaChecker.determineStrength(1));
    }
}
