package com.cognizant.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Spring Cloud API Gateway. With discovery-locator enabled, requests to
 *   http://localhost:9090/account-service/accounts/123
 * are routed to the account-service registered in Eureka.
 */
@SpringBootApplication
public class ApiGatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(ApiGatewayApplication.class, args);
    }
}
