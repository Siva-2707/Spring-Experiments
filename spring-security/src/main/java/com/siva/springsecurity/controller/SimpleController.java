package com.siva.springsecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class SimpleController {

    @GetMapping("home")
    public String home() {
        return "<h2> You are at home </h2>";
    }

    @GetMapping("secret")
    public String secret() {
        return "Secret content, available only over authentication";
    }

}
