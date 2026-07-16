package com.cognizant.ormlearn.repository;

import com.cognizant.ormlearn.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Spring Data JPA repository. Extending JpaRepository gives us CRUD
 * (save, findById, findAll, deleteById, ...) for free — no boilerplate.
 */
public interface CountryRepository extends JpaRepository<Country, String> {

    // ---- Query Method: derived automatically from the method name ----
    List<Country> findByNameContainingIgnoreCase(String name);

    // ---- HQL / JPQL query (operates on the entity, not the table) ----
    @Query("SELECT c FROM Country c WHERE c.name = :name")
    Country findByNameHql(@Param("name") String name);

    // ---- Native SQL query (operates on the actual COUNTRY table) ----
    @Query(value = "SELECT * FROM country WHERE co_code = :code", nativeQuery = true)
    Country findByCodeNative(@Param("code") String code);
}
