package com.pmcb.sbexp;

import org.springframework.stereotype.Service;

@Service
public class GreetingService {

    public String getAll() {

        return String.format("%s %s", getPart1(), getPart2());
    }

    public String getPart1() {
        return "Hello";
    }

    public String getPart2() {
        return "World";
    }

    private String getPart3() {
        return "xxx";
    }

}
