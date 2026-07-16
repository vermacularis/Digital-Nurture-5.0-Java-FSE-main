package com.cognizant.employee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Additional Spring REST hands-on: Controller -> Service -> Dao architecture,
 * serving employee and department data loaded from employee.xml.
 *
 * Run:  mvn spring-boot:run   (default port 8080)
 *   GET /employees
 *   GET /departments
 */
@SpringBootApplication
public class EmployeeRestApplication {
    public static void main(String[] args) {
        SpringApplication.run(EmployeeRestApplication.class, args);
    }
}
