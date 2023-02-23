package com.daniellesko.springboot101.repositories;

import com.daniellesko.springboot101.models.Products;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface ProductsRepository extends CrudRepository<Products, Integer> {

    // Je vzdy potrebne definovat SQL query, JDBC nedokaze napisat query z nazvu metody ako to robi JPA
    @Query("SELECT * FROM products WHERE name = :name")
    List<Products> findProductsByName(String name);
}
