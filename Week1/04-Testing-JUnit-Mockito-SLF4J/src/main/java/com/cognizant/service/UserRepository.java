package com.cognizant.service;

/**
 * Dependency that will be MOCKED in the Mockito exercises.
 * In a real app this would talk to a database.
 */
public interface UserRepository {
    String findNameById(int id);
    boolean save(String name);
}
