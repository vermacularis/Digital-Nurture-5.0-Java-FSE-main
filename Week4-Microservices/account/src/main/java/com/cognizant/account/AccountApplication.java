package com.cognizant.account;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Account microservice. @EnableDiscoveryClient registers it with Eureka.
 * (In Spring Cloud 2023 this is optional/auto, but kept for clarity per the handbook.)
 */
@SpringBootApplication
@EnableDiscoveryClient
public class AccountApplication {
    public static void main(String[] args) {
        SpringApplication.run(AccountApplication.class, args);
    }
}
