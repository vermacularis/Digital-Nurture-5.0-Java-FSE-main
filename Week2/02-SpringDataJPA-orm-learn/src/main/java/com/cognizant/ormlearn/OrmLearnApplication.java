package com.cognizant.ormlearn;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.service.CountryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

/**
 * orm-learn — Spring Data JPA + Hibernate demo (H2 in-memory).
 *
 * The CommandLineRunner exercises every mandatory JPA hands-on item once the
 * app starts:
 *   - Quick Example: list all countries (findAll)
 *   - Find a country based on country code (findById)
 *   - Add a new country (save)
 *   - Query Methods (findByNameContainingIgnoreCase)
 *   - HQL / JPQL query and Native SQL query
 *
 * Run:  mvn spring-boot:run
 */
@SpringBootApplication
public class OrmLearnApplication implements CommandLineRunner {

    private static final Logger LOG = LoggerFactory.getLogger(OrmLearnApplication.class);

    @Autowired
    private CountryService countryService;

    public static void main(String[] args) {
        SpringApplication.run(OrmLearnApplication.class, args);
    }

    @Override
    public void run(String... args) {
        LOG.info("=== Spring Data JPA - Quick Example: all countries ===");
        List<Country> countries = countryService.getAllCountries();
        countries.forEach(c -> LOG.info("{}", c));

        LOG.info("=== Find a country based on country code (IN) ===");
        LOG.info("{}", countryService.findCountryByCode("IN"));

        LOG.info("=== Add a new country (FR - France) ===");
        countryService.addCountry("FR", "France");
        LOG.info("Added. Total countries now: {}", countryService.getAllCountries().size());

        LOG.info("=== Query Method: name contains 'a' ===");
        countryService.searchByName("a").forEach(c -> LOG.info("{}", c));

        LOG.info("=== HQL query: name = 'Japan' ===");
        LOG.info("{}", countryService.findByNameHql("Japan"));

        LOG.info("=== Native query: code = 'US' ===");
        LOG.info("{}", countryService.findByCodeNative("US"));
    }
}
