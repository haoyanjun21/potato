package com.potato.rest.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class APIController {
    @Autowired
    APIProxy apiProxy;
    public static void main(String[] args) throws Exception {
        SpringApplication.run(APIController.class, args);
    }

    @RequestMapping("/api/{function}")
    String function(@PathVariable("function") String function) {
        return apiProxy.function(function);
    }

    @RequestMapping("/")
    String home() {
        return "Hello World!";
    }

}