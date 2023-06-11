package com.siva.demomvcproject.RestController;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.siva.demomvcproject.Bean.Hello;

@RestController
public class FirstController {

    @RequestMapping("/hello")
    public Hello sayHello() {
        return new Hello("Hello");
    }

}
