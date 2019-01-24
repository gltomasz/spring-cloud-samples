package com.example.spring.customer.domain;

class Customer extends BaseEntity{

    private String firstName;
    private String lastName;

    Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

     String getFirstName() {
        return firstName;
    }

     String getLastName() {
        return lastName;
    }
}
