package com.daniellesko.springboot101.repositories;

import com.daniellesko.springboot101.entities.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

public interface ProductsRepository extends JpaRepository<Products, Integer> {

    @Query("SELECT p FROM Products p WHERE p.name=:name")   // Vlastny zapis query (toto bude spustene namiesto implementacie query z nazvu metody)
    // Definicia nazvu metody dodrziavanim istych pravidiel sama vytvori query
    Products findProductsByName(@Param("name") String name);
}
