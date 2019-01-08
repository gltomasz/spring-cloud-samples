package com.example.domain;

import com.example.infrastructure.Gateway;
import com.example.infrastructure.UserDTO;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GatewayTest {

    private static Gateway api;

    @BeforeAll
    private static void setUp() {
        api = new Gateway(new UserFacade(new UserRepository()));
    }

    @Test
    void credentialsMatch() {
        assertTrue(api.credentialsMatch(new UserDTO("john.doe", "test")));
        assertTrue(api.credentialsMatch(new UserDTO("test.user", "test")));
        assertTrue(api.credentialsMatch(new UserDTO("mike.claim", "test")));
    }
}