package com.cognizant.ormlearn.service;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Service layer for Country. @Transactional ensures each method runs inside
 * a database transaction (session opened/closed by Spring).
 */
@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    @Transactional
    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }

    /** Find a country based on country code (primary key). */
    @Transactional
    public Country findCountryByCode(String code) {
        return countryRepository.findById(code).orElse(null);
    }

    /** Add a new country. */
    @Transactional
    public Country addCountry(String code, String name) {
        return countryRepository.save(new Country(code, name));
    }

    // ---- demonstrate query method + HQL + native query ----
    @Transactional
    public List<Country> searchByName(String namePart) {
        return countryRepository.findByNameContainingIgnoreCase(namePart);
    }

    @Transactional
    public Country findByNameHql(String name) {
        return countryRepository.findByNameHql(name);
    }

    @Transactional
    public Country findByCodeNative(String code) {
        return countryRepository.findByCodeNative(code);
    }
}
