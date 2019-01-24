package com.example.spring.order.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping(value = "/orders")
class OrdersEndpoint {

    @GetMapping(value = "/customer/{id}")
    List<OrderDto> ordersForCustomer(@PathVariable(value = "id") Long customerId) {
        ShippingAddressDto address = createShippingAddress();
        OrderDto order = createOrder(customerId, address);
        return Collections.singletonList(order);
    }

    private ShippingAddressDto createShippingAddress() {
        return new ShippingAddressDtoBuilder().
                setAddress(String.format("%s/%s", randomInt(1, 99), randomInt(1, 199))).
                setCity("London").
                setStreet("No Name").
                createShippingAddress();
    }

    private OrderDto createOrder(Long customerId, ShippingAddressDto address) {
        return new OrderDtoBuilder().
                setAddress(address).
                setCustomerId(customerId).
                setDate(LocalDate.of(randomInt(2015, 2018), randomInt(1, 12), randomInt(1, 28))).
                setTotalSum(BigDecimal.valueOf(new Random().nextDouble() + 100).setScale(2, RoundingMode.CEILING)).
                createOrder();
    }

    private int randomInt(int min, int max) {
        return new Random().nextInt(max + 1 - min) + min;
    }

}
