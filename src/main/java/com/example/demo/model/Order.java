package com.example.demo.model;


import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
public class Order {                // Використання Lombok
    private UUID id;
    private List<Product> products;

    public Order() {
        this.id = UUID.randomUUID();
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        this.products.add(product);
    }

    public void removeProduct(UUID productId) {
        this.products.removeIf(p -> p.getId().equals(productId));
    }
}
