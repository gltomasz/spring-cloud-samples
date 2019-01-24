package com.example.spring.order.api;

import java.math.BigDecimal;
import java.time.LocalDate;

public class OrderDto {

    private Long customerId;
    private BigDecimal totalSum;
    private LocalDate date;
    private ShippingAddressDto shippingAddress;


    OrderDto(Long customerId, BigDecimal totalSum, LocalDate date, ShippingAddressDto shippingAddress) {
        this.setCustomerId(customerId);
        this.setTotalSum(totalSum);
        this.setDate(date);
        this.setShippingAddress(shippingAddress);
    }

    public OrderDto() {
    }

    public Long getCustomerId() {
        return customerId;
    }

    void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public BigDecimal getTotalSum() {
        return totalSum;
    }

    void setTotalSum(BigDecimal totalSum) {
        this.totalSum = totalSum;
    }

    public String getDate() {
        return date.toString();
    }

    void setDate(LocalDate date) {
        this.date = date;
    }

    public ShippingAddressDto getShippingAddress() {
        return shippingAddress;
    }

    void setShippingAddress(ShippingAddressDto shippingAddress) {
        this.shippingAddress = shippingAddress;
    }
}
