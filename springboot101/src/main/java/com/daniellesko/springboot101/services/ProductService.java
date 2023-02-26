package com.daniellesko.springboot101.services;

import com.daniellesko.springboot101.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    ProductRepository repository;

    public List<String> getProductNamesWithEvenNoOfChar() {
        List<String> names = repository.getProductNames();

        /*List<String> result = new ArrayList<>();
        for (String n : names) {
            if (n.length() % 2 == 0) {
                result.add(n);
                //repository.addProduct(n); // volanie verify
            }
        }
        return result;
        */

        // Refaktorovanie kodu
        return names.stream()
                .filter(n -> n.length() %2 == 0)
                .collect(Collectors.toList());
    }
}
