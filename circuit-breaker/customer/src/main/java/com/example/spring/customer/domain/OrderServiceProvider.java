package com.example.spring.customer.domain;

import com.example.spring.customer.domain.dto.OrderDto;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class OrderServiceProvider implements OrderService {

    private RestTemplate orderRestTemplate;

    OrderServiceProvider(RestTemplate restTemplate) {
        this.orderRestTemplate = restTemplate;
    }

    @Override
    public List<OrderDto> ordersForCustomer(Long customerId) {
        Map<String, Object> params = new HashMap<>(1);
        params.put("id", customerId);
        String path = UriComponentsBuilder.fromPath("/orders/customer/{id}").buildAndExpand(params).toUriString();
        return orderRestTemplate.exchange(path, HttpMethod.GET, null, new ParameterizedTypeReference<List<OrderDto>>() {}).getBody();
    }

}
