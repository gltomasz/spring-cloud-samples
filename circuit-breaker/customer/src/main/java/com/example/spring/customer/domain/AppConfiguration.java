package com.example.spring.customer.domain;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;

@Configuration
class AppConfiguration {

    @Value("${orders.service.host}")
    private String orderServiceHost;

    @Value("${orders.service.port}")
    private String orderServicePort;

    @Bean
    CustomerRepository repository() {return new InMemoryCustomerRepository();}

    @Bean
    CustomerFacade facade(CustomerRepository repository, OrderService orderService) {
        return new CustomerFacade(repository, orderService);
    }

    CustomerFacade facade() {
        return new CustomerFacade(new InMemoryCustomerRepository(), null);
    }

    @Bean
    RestTemplate orderRestTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setUriTemplateHandler(new DefaultUriBuilderFactory(orderServiceHost + ":" + orderServicePort));
        return restTemplate;
    }

    @Bean
    OrderService orderService(RestTemplate orderRestTemplate) {return new OrderServiceProvider(orderRestTemplate);}

}
