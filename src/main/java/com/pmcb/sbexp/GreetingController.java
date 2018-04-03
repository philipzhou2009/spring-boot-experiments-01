package com.pmcb.sbexp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {



    @GetMapping(path = "/greeting")
    public String greeting() {

        return "Greeting";
    }
}
