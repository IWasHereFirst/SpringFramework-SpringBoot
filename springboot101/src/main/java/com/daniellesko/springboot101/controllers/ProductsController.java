package com.daniellesko.springboot101.controllers;

import com.daniellesko.springboot101.entities.Products;
import com.daniellesko.springboot101.repositories.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductsController {

    @Autowired
    private ProductsRepository repository;

    // @RequestBody mapuje hodnoty do DTO (Data Transfer Object) Products, ktory pomocou repository je vlozeny do DB
    @PostMapping("/add")
    public void addProduct(@RequestBody Products p){
        repository.save(p);
    }

    @GetMapping("/get/{name}")
    public Products getProduct(@PathVariable String name) {
        return repository.findProductsByName(name);
    }

}
