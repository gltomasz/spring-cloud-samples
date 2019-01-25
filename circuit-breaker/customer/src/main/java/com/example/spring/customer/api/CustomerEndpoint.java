package com.example.spring.customer.api;

import com.example.spring.customer.domain.dto.CustomerDto;
import com.example.spring.customer.domain.CustomerFacade;
import com.example.spring.customer.api.exception.NotFoundException;
import com.example.spring.customer.domain.dto.OrderDto;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@Component
class CustomerEndpoint {

    private CustomerFacade customerFacade;
    private Logger logger = LoggerFactory.getLogger(CustomerEndpoint.class);

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
        logger.info("Trying to get orders for customer {}" , customerId);
        List<OrderDto> orderDtos = customerFacade.ordersForCustomer(customerId);
        logger.info("Returning orders for customer {}", customerId);
        return orderDtos;
    }

    List<OrderDto> reliable(Long customerId) {
        logger.info("Getting empty list");
        return Collections.emptyList();
    }

}
