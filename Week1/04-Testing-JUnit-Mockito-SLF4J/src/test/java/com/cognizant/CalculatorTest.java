package com.cognizant;

import com.cognizant.calc.Calculator;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * JUnit 5 mandatory exercises in one test class:
 *
 *  Exercise 1 - Setting Up JUnit  : a compiling @Test that runs with `mvn test`.
 *  Exercise 3 - Assertions        : assertEquals, assertTrue, assertNotNull, assertThrows...
 *  Exercise 4 - AAA + Fixtures     : Arrange-Act-Assert structure with
 *                                    @BeforeAll/@BeforeEach/@AfterEach/@AfterAll lifecycle.
 */
class CalculatorTest {

    private Calculator calculator; // test fixture, recreated before each test

    @BeforeAll
    static void initAll() {
        System.out.println("@BeforeAll  - runs once before all tests");
    }

    @BeforeEach
    void setUp() {
        // Arrange (shared): fresh instance so tests don't affect each other.
        calculator = new Calculator();
        System.out.println("@BeforeEach - new Calculator created");
    }

    // ---------- Exercise 1: a basic passing test ----------
    @Test
    @DisplayName("Exercise 1: JUnit is set up and runs a test")
    void testSetup() {
        assertNotNull(calculator, "Calculator fixture should be initialised");
    }

    // ---------- Exercise 3: assertions ----------
    @Test
    @DisplayName("Exercise 3: assorted assertions")
    void testAssertions() {
        assertEquals(5, calculator.add(2, 3));            // equality
        assertEquals(6, calculator.multiply(2, 3));
        assertTrue(calculator.subtract(5, 3) > 0);        // boolean condition
        assertNotNull(calculator);                        // not null
        assertEquals(2.5, calculator.divide(5, 2), 0.001);// floating point w/ delta

        // asserting an exception is thrown
        assertThrows(ArithmeticException.class, () -> calculator.divide(1, 0));
    }

    // ---------- Exercise 4: Arrange-Act-Assert pattern ----------
    @Test
    @DisplayName("Exercise 4: Arrange-Act-Assert")
    void testAddUsingAAA() {
        // Arrange
        int a = 10;
        int b = 15;

        // Act
        int result = calculator.add(a, b);

        // Assert
        assertEquals(25, result);
    }

    @AfterEach
    void tearDown() {
        System.out.println("@AfterEach  - test finished");
    }

    @AfterAll
    static void tearDownAll() {
        System.out.println("@AfterAll   - runs once after all tests");
    }
}
