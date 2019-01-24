package com.example.spring.customer.domain;

interface CustomerRepository {

    Customer customerForId(Long id);
}
