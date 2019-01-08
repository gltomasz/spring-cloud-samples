package com.example.domain;

import java.util.*;

class UserRepository {

    private Map<Integer, User> database;

    UserRepository() {
        database = new HashMap<>();
        database.put(1, new User("john.doe","test"));
        database.put(2, new User("test.user","test"));
        database.put(3, new User("mike.claim","test"));
    }

    public Optional<User> userForName(String name) {
        return database.values().stream().filter(p -> p.getUsername().equals(name)).findFirst();
    }

}
