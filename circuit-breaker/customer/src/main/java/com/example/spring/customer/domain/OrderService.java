package com.example.spring.customer.domain;

import com.example.spring.customer.domain.dto.OrderDto;

import java.util.List;

interface OrderService {

    List<OrderDto> ordersForCustomer(Long customerId);
}
