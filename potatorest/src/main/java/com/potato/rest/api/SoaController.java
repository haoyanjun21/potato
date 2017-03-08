package com.potato.rest.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class SoaController {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(SoaController.class, args);
    }

    @RequestMapping("/soa/{function}")
    String function(@PathVariable("function") String function) {
        return "soa function " + function + " return";
    }

}