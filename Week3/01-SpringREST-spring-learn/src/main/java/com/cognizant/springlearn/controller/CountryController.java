package com.cognizant.springlearn.controller;

import com.cognizant.springlearn.model.Country;
import com.cognizant.springlearn.service.CountryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Hands-on 2: Country web services.
 *
 *   GET /country          -> India, loaded from country.xml     (getCountryIndia)
 *   GET /countries        -> all countries
 *   GET /country/{code}   -> a single country by its code       (get by code)
 *
 * Country beans are converted to JSON automatically by Jackson.
 */
@RestController
public class CountryController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CountryController.class);

    @Autowired
    private CountryService countryService;

    @GetMapping("/country")
    public Country getCountryIndia() {
        LOGGER.info("START getCountryIndia()");
        Country country = countryService.getCountry();
        LOGGER.info("END getCountryIndia()");
        return country;
    }

    @GetMapping("/countries")
    public List<Country> getAllCountries() {
        return countryService.getAllCountries();
    }

    @GetMapping("/country/{code}")
    public Country getCountry(@PathVariable String code) {
        LOGGER.info("START getCountry(code={})", code);
        Country country = countryService.getCountry(code);
        LOGGER.info("END getCountry()");
        return country;
    }
}
