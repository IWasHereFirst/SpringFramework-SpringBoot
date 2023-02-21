package com.daniellesko.springboot101.controllers;

import com.daniellesko.springboot101.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService service;

    @PostMapping("/add/{name}")
    public void addProduct(@PathVariable String name){

        service.addProduct(name);
    }

}
