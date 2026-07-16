package com.cognizant.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * SLF4J Exercise 1: Logging Error Messages and Warning Levels.
 *
 * Demonstrates the SLF4J logging levels (error, warn, info, debug, trace) and
 * parameterized logging. Actual output/formatting is controlled by Logback
 * (see src/main/resources/logback.xml).
 *
 * Run:  mvn compile exec:java -Dexec.mainClass=com.cognizant.logging.LoggingExample
 */
public class LoggingExample {

    private static final Logger logger = LoggerFactory.getLogger(LoggingExample.class);

    public static void main(String[] args) {
        logger.info("Application started");
        logger.debug("This is a DEBUG message (visible if level = DEBUG)");

        String user = "Ravi";
        int attempts = 3;

        // Parameterized logging ({} placeholders) - efficient, no string concatenation.
        logger.warn("User {} has {} failed login attempts", user, attempts);

        try {
            int result = 10 / 0; // force an exception
            logger.info("Result = {}", result);
        } catch (ArithmeticException e) {
            // Log an ERROR with the exception stack trace as the last argument.
            logger.error("Error while processing request for user {}: {}", user, e.getMessage(), e);
        }

        logger.info("Application finished");
    }
}
