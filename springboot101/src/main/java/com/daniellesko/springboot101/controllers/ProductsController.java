package com.daniellesko.springboot101.controllers;

import com.daniellesko.springboot101.model.Products;
import com.daniellesko.springboot101.repositories.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductsController {

    @Autowired
    ProductsRepository repository;

    @PostMapping("/add/{name}")
    public void addProduct(@PathVariable String name){
        Products p = new Products();
        p.setName(name);
        repository.save(p);
    }

    @GetMapping("/all")
    public List<Products> getAllProducts(){
        return repository.findAll();
    }

}
