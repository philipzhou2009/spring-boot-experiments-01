package com.pmcb.sbexp;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

public class GreetingServiceTest {

    private GreetingService service;

    @Before
    public void setUp() throws Exception {
        service = new GreetingService();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getAll() {
        when(service.getPart1()).thenReturn("p1");
        when(service.getPart2()).thenReturn("p2");


        String result = service.getAll();
        assertThat(result).isEqualTo("p1p2");
    }

    @Test
    public void getPart1() {
    }

    @Test
    public void getPart2() {
    }
}