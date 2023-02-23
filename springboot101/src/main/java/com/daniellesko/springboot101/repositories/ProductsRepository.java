package com.daniellesko.springboot101.repositories;

import com.daniellesko.springboot101.entities.Products;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface ProductsRepository extends PagingAndSortingRepository<Products, Integer> {

    // Je mozne pouzit Pageable ako ako argument aj Sort ako argument, no nie je mozne ich pouzit oba naraz.
    // Vtedy je potrebne vyuzit Pageable

    // List<Products> findProductsByName(String name, Sort sort);  // vlozenie Sort objektu na zoradenie
    List<Products> findProductsByName(String name, Pageable page);
}
