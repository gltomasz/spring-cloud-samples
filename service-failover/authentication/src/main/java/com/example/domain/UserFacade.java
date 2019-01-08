package com.example.domain;

import java.util.Optional;

public class UserFacade {

    private UserRepository repository;

    UserFacade(UserRepository repository) {
        this.repository = repository;
    }

    public boolean credentialsMatch(String userName, String password) {
        Optional<User> user = repository.userForName(userName);
        return user.isPresent() && user.get().credentialsMatch(password);
    }
}
