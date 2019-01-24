package com.example.spring.customer.api;

import com.example.spring.customer.domain.dto.CustomerDto;
import com.example.spring.customer.domain.CustomerFacade;
import com.example.spring.customer.api.exception.NotFoundException;
import com.example.spring.customer.domain.dto.OrderDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
class CustomerEndpoint {

    private CustomerFacade customerFacade;

    CustomerEndpoint(CustomerFacade customerFacade) {
        this.customerFacade = customerFacade;
    }

    @GetMapping(path = "/{id}")
    CustomerDto customerForId(@PathVariable Long id){
        return customerFacade.customerForId(id).orElseThrow(NotFoundException::new);
    }

    @GetMapping(path = "/customer/{id}/orders")
    List<OrderDto> ordersForCustomer(@PathVariable("id") Long customerId) {
        return customerFacade.ordersForCustomer(customerId);
    }
}
