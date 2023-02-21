package com.daniellesko.springboot101.services;

import com.daniellesko.springboot101.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    ProductRepository repository;

    public void addProduct(String name) {

        repository.addProduct(name);
    }

}
