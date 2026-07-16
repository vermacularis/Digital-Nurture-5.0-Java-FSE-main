package com.cognizant.springlearn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hands-on 1: Create a Spring Web Project using Maven.
 *
 * @SpringBootApplication bundles @Configuration + @EnableAutoConfiguration +
 * @ComponentScan. SpringApplication.run() starts the embedded Tomcat server.
 */
@SpringBootApplication
public class SpringLearnApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);

    public static void main(String[] args) {
        LOGGER.info("START main()");
        SpringApplication.run(SpringLearnApplication.class, args);
        LOGGER.info("END main()");
    }
}
