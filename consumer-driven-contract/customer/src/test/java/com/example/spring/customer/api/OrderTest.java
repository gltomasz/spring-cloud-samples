package com.example.spring.customer.api;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerPort;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
@AutoConfigureStubRunner(
        ids = {"com.example.spring:order:+:stubs"},
        stubsMode = StubRunnerProperties.StubsMode.LOCAL)
public class OrderTest {

    @Autowired
    private MockMvc mockMvc;

    @StubRunnerPort("order")
    private int producerPort;

    @Autowired
    RestTemplate orderRestTemplate;

    @Before
    public void before() {
        orderRestTemplate.setUriTemplateHandler(new DefaultUriBuilderFactory("http://localhost:" + producerPort));
    }

    @Test
    public void shouldReturnOrdersForGivenCustomer() throws Exception {

        mockMvc.perform(get("/customer/{id}/orders", 2))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.[0].customerId", is(2)));
    }
}
