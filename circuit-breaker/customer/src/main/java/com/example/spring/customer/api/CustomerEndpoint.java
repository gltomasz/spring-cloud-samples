package com.example.spring.customer.api;

import com.example.spring.customer.domain.dto.CustomerDto;
import com.example.spring.customer.domain.CustomerFacade;
import com.example.spring.customer.api.exception.NotFoundException;
import com.example.spring.customer.domain.dto.OrderDto;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@Component
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
    @HystrixCommand(fallbackMethod = "reliable")
    List<OrderDto> ordersForCustomer(@PathVariable("id") Long customerId) {
        return customerFacade.ordersForCustomer(customerId);
    }

    List<OrderDto> reliable(Long customerId) {
        return Collections.emptyList();
    }

}
