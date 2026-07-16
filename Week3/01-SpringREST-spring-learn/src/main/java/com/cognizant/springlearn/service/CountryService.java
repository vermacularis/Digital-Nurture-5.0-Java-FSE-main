package com.cognizant.springlearn.service;

import com.cognizant.springlearn.model.Country;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * Loads country data. getCountry() reads the India bean from country.xml
 * (Spring XML configuration), demonstrating bean loading; the list/by-code
 * methods back the "get all" and "get by code" REST endpoints.
 */
@Service
public class CountryService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CountryService.class);

    private static final List<Country> COUNTRIES = Arrays.asList(
            new Country("IN", "India"),
            new Country("US", "United States of America"),
            new Country("DE", "Germany"),
            new Country("JP", "Japan")
    );

    /** Hands-on: Load India bean from spring xml configuration and return. */
    public Country getCountry() {
        LOGGER.info("START getCountry()");
        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
        Country country = context.getBean("country", Country.class);
        LOGGER.info("END getCountry()");
        return country;
    }

    public List<Country> getAllCountries() {
        return COUNTRIES;
    }

    /** Hands-on: Get country based on country code. */
    public Country getCountry(String code) {
        LOGGER.info("START getCountry(code={})", code);
        Country match = COUNTRIES.stream()
                .filter(c -> c.getCode().equalsIgnoreCase(code))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("No country found for code: " + code));
        LOGGER.info("END getCountry(code)");
        return match;
    }
}
