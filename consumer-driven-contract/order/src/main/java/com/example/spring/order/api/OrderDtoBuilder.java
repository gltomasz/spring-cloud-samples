package com.example.spring.order.api;

import java.math.BigDecimal;
import java.time.LocalDate;

class OrderDtoBuilder {
    private Long customerId;
    private BigDecimal totalSum;
    private LocalDate date;
    private ShippingAddressDto address;

    OrderDtoBuilder setCustomerId(Long customerId) {
        this.customerId = customerId;
        return this;
    }

    OrderDtoBuilder setTotalSum(BigDecimal totalSum) {
        this.totalSum = totalSum;
        return this;
    }

    OrderDtoBuilder setDate(LocalDate date) {
        this.date = date;
        return this;
    }

    OrderDtoBuilder setAddress(ShippingAddressDto address) {
        this.address = address;
        return this;
    }

    OrderDto createOrder() {
        return new OrderDto(customerId, totalSum, date, address);
    }
}