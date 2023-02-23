package com.daniellesko.springboot101.models;

import org.springframework.data.annotation.Id;
// Neexistuje anotacia @Entity
public class Products {

    @Id
    private int id;

    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
