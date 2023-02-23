package com.daniellesko.springboot101.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document
public class Products {

    @Id
    private String id;
    private String name;

    // Pri kazdom vygenerovani tohto objektu sa vytvori jedinecne ID
    public Products() {
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
