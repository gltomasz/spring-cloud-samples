package com.example.spring.customer.domain;

import org.junit.BeforeClass;
import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class CustomerFacadeTest {

    private static CustomerFacade facade;

    @BeforeClass
    public static void beforeAll() {
        facade = new AppConfiguration().facade();
    }

    @Test
    public void shouldReturnCustomerForGivenId() {
        assertThat(facade.customerForId(1L)).isPresent();
        assertThat(facade.customerForId(2L)).isPresent();
    }

    @Test
    public void shouldReturnEmptyOptionalForGivenId() {
        assertThat(facade.customerForId(3L)).isEmpty();
    }
}