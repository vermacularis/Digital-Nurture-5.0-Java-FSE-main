package com.library.repository;

import java.util.Arrays;
import java.util.List;

/**
 * Data-access layer for books. In a real app this would query a database;
 * here it returns a fixed list so we can focus on Spring wiring.
 */
public class BookRepository {

    public List<String> getAllBooks() {
        return Arrays.asList(
                "Clean Code - Robert C. Martin",
                "Effective Java - Joshua Bloch",
                "Spring in Action - Craig Walls"
        );
    }
}
