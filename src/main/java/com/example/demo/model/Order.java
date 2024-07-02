package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Order {
    private UUID id;
    private List<Product> products;

    public Order() {
        this.id = UUID.randomUUID();
        this.products = new ArrayList<>();
    }

    public UUID getId() {
        return id;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public void addProduct(Product product) {
        this.products.add(product);
    }

    public void removeProduct(UUID productId) {
        this.products.removeIf(p -> p.getId().equals(productId));
    }
}
