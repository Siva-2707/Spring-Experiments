package com.siva.microservice.limitsservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.siva.microservice.limitsservice.bean.Limits;
import com.siva.microservice.limitsservice.configuration.LimitConfig;

@RestController
public class LimitsController {

    @Autowired
    LimitConfig config;

    @GetMapping("/limits")
    public Limits retriveLimits() {
        return new Limits(config.getMinimum(), config.getMaximum());
    }

}
