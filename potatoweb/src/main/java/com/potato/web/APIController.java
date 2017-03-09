package com.potato.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class APIController {
    @Autowired
    APIProxy apiProxy;

    @RequestMapping("/api/{function}")
    String function(@PathVariable("function") String function) {
        return apiProxy.function(function);
    }

    @RequestMapping("/")
    String home() {
        return "Hello World!";
    }

}