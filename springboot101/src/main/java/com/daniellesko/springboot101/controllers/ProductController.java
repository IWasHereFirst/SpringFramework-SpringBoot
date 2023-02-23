package com.daniellesko.springboot101.controllers;

import com.daniellesko.springboot101.models.Products;
import com.daniellesko.springboot101.repositories.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    ProductsRepository repository;

    // CrudRepository vracia Iterable<Object>
    @GetMapping("/all")
    public Iterable<Products> getAll(){
        return repository.findAll();    // JDBC poskytuje zakladne CRUD operacie
    }

    @GetMapping("/name/{name}")
    public List<Products> findAll(@PathVariable String name) {
        return repository.findProductsByName(name);
    }

}
