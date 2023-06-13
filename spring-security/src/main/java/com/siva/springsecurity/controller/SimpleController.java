package com.siva.springsecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class SimpleController {


    //Accessible to all
    @GetMapping("home")
    public String home() {
        return "<h2> You are at home </h2>";
    }

    //Authentication
    //All authorized users can access
    @GetMapping("secret")
    public String secret() {
        return "Secret content, available only over authentication";
    }

    //Authorization
    //Users with ROLE as ADMIN can
    @GetMapping("admin")
    public String adminPage(){
        return "Welcome to admin page";
    }

    

}
