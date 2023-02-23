package com.daniellesko.springboot101.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello(){
        return "Hello";
    }

    @GetMapping("/mellow")
    public String mellow(){
        return "Mellow!";
    }
}
