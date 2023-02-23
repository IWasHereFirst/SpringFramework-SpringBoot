package com.daniellesko.springboot101.repositories;

import com.daniellesko.springboot101.model.Products;
import org.springframework.data.mongodb.repository.MongoRepository;

// Id je typu String, preto je <Products, String>
public interface ProductsRepository extends MongoRepository<Products, String> {
}
