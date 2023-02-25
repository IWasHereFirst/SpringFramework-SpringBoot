package com.daniellesko.springboot101.controllers;

import com.daniellesko.springboot101.services.MyService;
import com.daniellesko.springboot101.services.RandomNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @Autowired
    private MyService numberService;  // proxy

    @GetMapping("/home")
    public String index(Model model) {  // Model je objekt, ktory prenasa data z metody do view
        model.addAttribute("message", numberService.getValue());    // message je nazov premennej v Thymeleaf index.html
        return "index.html";
    }

}
