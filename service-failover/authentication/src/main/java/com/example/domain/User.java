package com.example.domain;

class User {

    private String username;
    private String password;

    User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    boolean credentialsMatch(String password) {
        return this.password.equals(password);
    }

    String getUsername() {
        return username;
    }
}
