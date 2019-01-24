package com.example.spring.customer.domain.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class OrderDto {

    private Long customerId;
    private BigDecimal totalSum;
    private LocalDate date;
    private ShippingAddressDto shippingAddress;

    public OrderDto() {
    }

    public OrderDto(Long customerId, BigDecimal totalSum, LocalDate date, ShippingAddressDto shippingAddress) {
        this.customerId = customerId;
        this.totalSum = totalSum;
        this.date = date;
        this.shippingAddress = shippingAddress;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public BigDecimal getTotalSum() {
        return totalSum;
    }

    public void setTotalSum(BigDecimal totalSum) {
        this.totalSum = totalSum;
    }

    public String getDate() {
        return date.toString();
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public ShippingAddressDto getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(ShippingAddressDto shippingAddress) {
        this.shippingAddress = shippingAddress;
    }
}
