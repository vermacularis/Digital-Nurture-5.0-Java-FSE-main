package com.cognizant.springlearn.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Hands-on 2: Hello World RESTful Web Service.
 *
 * GET /hello  ->  "Hello World!!"
 * Start and end logs are included as required by the exercise.
 */
@RestController
public class HelloController {

    private static final Logger LOGGER = LoggerFactory.getLogger(HelloController.class);

    @GetMapping("/hello")
    public String sayHello() {
        LOGGER.info("START sayHello()");
        String message = "Hello World!!";
        LOGGER.info("END sayHello()");
        return message;
    }
}
