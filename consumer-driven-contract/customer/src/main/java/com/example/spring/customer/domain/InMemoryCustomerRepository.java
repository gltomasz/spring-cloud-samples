package com.example.spring.customer.domain;

class InMemoryCustomerRepository implements CustomerRepository {

    private InMemoryDatabase<Customer> database;

    InMemoryCustomerRepository() {
        database = new InMemoryDatabase<>();
        database.add(new Customer("John", "Doe"));
        database.add(new Customer("Mike", "Tyson"));
    }

    @Override
    public Customer customerForId(Long id) {
        return database.get(id);
    }
}
