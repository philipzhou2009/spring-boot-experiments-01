package com.pmcb.sbexp;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Method;

import static com.pmcb.sbexp.TestUtils.genericInvokMethod;
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

        Method[] method = GreetingService.class.getDeclaredMethods();
    }

    @Test
    public void getPart1() {
    }

    @Test
    public void getPart2() {
    }

    @Test
    public void getPart3() throws Exception {
        int i = 3;
//        System.out.println(i.);


//        Method method = GreetingService.class.getDeclaredMethod(
//                "getPart3",
//                Integer.TYPE,
//                String.class);

//        System.out.println(int.class);


        String p3 = (String) genericInvokMethod(service, "getPart3", 1, "xxx");
//
//        assertThat(p3).isEqualTo("xxx");
    }
}