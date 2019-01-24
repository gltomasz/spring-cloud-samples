package com.example.spring.order.api;

import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Before;

public class OrderBase {

    @Before
    public void setup() {
        RestAssuredMockMvc.standaloneSetup(new OrdersEndpoint());
    }

}
