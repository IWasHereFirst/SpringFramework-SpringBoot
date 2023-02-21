package com.daniellesko.springboot101.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ProductRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public void addProduct(String name) {

        String sql = "INSERT INTO products VALUES(NULL, ?)";
        jdbcTemplate.update(sql, name);
    }

}
