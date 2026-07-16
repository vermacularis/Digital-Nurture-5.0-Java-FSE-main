package com.cognizant.service;

/**
 * Class under test for the Mockito exercises. It depends on UserRepository,
 * which we mock so we can test UserService in isolation.
 */
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /** Returns an uppercase greeting for the user with the given id. */
    public String getGreeting(int id) {
        String name = userRepository.findNameById(id);
        if (name == null) {
            return "User not found";
        }
        return "Hello, " + name + "!";
    }

    /** Registers a user; delegates persistence to the repository. */
    public boolean register(String name) {
        return userRepository.save(name);
    }
}
