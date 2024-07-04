package com.example.demo.model;

import lombok.Data;

import java.util.UUID;

@Data
public class Product {              //  Використання Lombok
    private UUID id;
    private String name;
    private double price;

    public Product() {
        this.id = UUID.randomUUID();
    }
}
