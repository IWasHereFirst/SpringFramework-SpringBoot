package com.daniellesko.springboot101.entities;

import jakarta.persistence.*;

@Entity // Oznacuje triedu ako entitu, ktora reprezentuje tabulku v DB a ma fields prisluchajuce stlpcom tabulky
//@Table(name = "products")   // ak sa nazov triedy nezhoduje s nazvom tabulky je potrebne specifikovat tabulku ku ktorej dana trieda patri
public class Products {

    @Id // kazda entita musi mat @Id ako primary key v tabulke
    @GeneratedValue(strategy = GenerationType.IDENTITY) // typ IDENTITY naznacuje, ze o auto increment sa stara DB
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
