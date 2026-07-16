package com.cognizant;

import com.cognizant.service.UserRepository;
import com.cognizant.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

/**
 * Mockito mandatory exercises:
 *
 *  Exercise 1 - Mocking & Stubbing : @Mock a UserRepository and stub its methods
 *                                    with when(...).thenReturn(...).
 *  Exercise 2 - Verifying Interactions : verify(...) that the mock was called the
 *                                        expected number of times / with given args.
 */
@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository userRepository;   // the mocked dependency

    @InjectMocks
    private UserService userService;         // mock injected into this

    // ---------- Exercise 1: Mocking and Stubbing ----------
    @Test
    void testGetGreeting_stubbing() {
        // Stub: define what the mock returns for a given input.
        when(userRepository.findNameById(1)).thenReturn("Ravi");

        String greeting = userService.getGreeting(1);

        assertEquals("Hello, Ravi!", greeting);
    }

    @Test
    void testGetGreeting_userNotFound() {
        when(userRepository.findNameById(99)).thenReturn(null);

        assertEquals("User not found", userService.getGreeting(99));
    }

    // ---------- Exercise 2: Verifying Interactions ----------
    @Test
    void testRegister_verifyInteraction() {
        when(userRepository.save("Anita")).thenReturn(true);

        boolean result = userService.register("Anita");

        assertEquals(true, result);
        // Verify the repository's save() was called exactly once with "Anita".
        verify(userRepository, times(1)).save("Anita");
        // Verify no other interactions happened on the mock.
        verifyNoMoreInteractions(userRepository);
    }

    @Test
    void testGetGreeting_verifyFindCalled() {
        when(userRepository.findNameById(anyInt())).thenReturn("Sara");

        userService.getGreeting(5);

        verify(userRepository).findNameById(5);   // called with the exact argument
    }
}
