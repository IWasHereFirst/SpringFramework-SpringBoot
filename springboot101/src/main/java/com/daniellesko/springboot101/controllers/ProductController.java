package com.daniellesko.springboot101.controllers;

import com.daniellesko.springboot101.entities.Products;
import com.daniellesko.springboot101.repositories.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    ProductsRepository repository;

    @GetMapping("/sort")
    public Iterable<Products> getAllSortedDescendingById() {
        // Sort.by("id").and(Sort.by("name")).descending());  // usporiadanie na viacerych stlpcoch
        return repository.findAll(Sort.by("id").descending());  // usporiadanie na jednom stlpci
    }

    // Kedze repository.findAll(PageRequest.of(page, 2)) vracia Page objekt, tak pomocou .getContent() sa ziska z tohto objektu obsah a vrati ho v Liste
    // Tu je zadefinovane Paging aj Sorting v jednej metode
    @GetMapping("/page/{page}")
    public List<Products> getProductsByPage(@PathVariable int page) {
        Sort s = Sort.by("id").ascending();
        return repository.findAll(PageRequest.of(page, 2, s)).getContent();
    }

    // Pageable (org.springframework.data.domain)
    @GetMapping("/name/{name}/{page}")
    public List<Products> getProductsByName(@PathVariable String name, @PathVariable int page) {
        Pageable p = PageRequest.of(page, 2);   // vytvorenie page objektu

        //return repository.findProductsByName(name, Sort.by("id").descending()); // pridanie Sort objektu na zoradenie vysledkov
        return repository.findProductsByName(name, p); // pridanie Pageable objektu na zobrazenie len urciteho poctu stran
    }
}
