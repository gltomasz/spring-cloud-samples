package com.example.spring.customer.domain;

import com.example.spring.customer.domain.dto.CustomerDto;
import com.example.spring.customer.domain.dto.OrderDto;

import java.util.List;
import java.util.Optional;

public class CustomerFacade {

    private CustomerRepository repository;
    private OrderService orderService;

    public CustomerFacade(CustomerRepository repository, OrderService orderService) {
        this.repository = repository;
        this.orderService = orderService;
    }

    public Optional<CustomerDto> customerForId(Long customerId) {
        Customer customer = repository.customerForId(customerId);
        return Optional.ofNullable(customer).map(
                p -> new CustomerDto(p.getFirstName(), p.getLastName())
        );
    }

    public List<OrderDto> ordersForCustomer(Long customerId) {
        return orderService.ordersForCustomer(customerId);
    }
}
