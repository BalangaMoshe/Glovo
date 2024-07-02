package com.example.demo.service;

import com.example.demo.model.Order;
import com.example.demo.model.Product;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@Service
public class OrderService {
    private final Map<UUID, Order> orders = new HashMap<>();

    public Optional<Order> getOrderById(UUID id) {
        return Optional.ofNullable(orders.get(id));
    }

    public Order addOrder() {
        Order order = new Order();
        orders.put(order.getId(), order);
        return order;
    }

    public Optional<Order> updateOrder(UUID id, Order updatedOrder) {
        if (orders.containsKey(id)) {
            updatedOrder.setProducts(orders.get(id).getProducts());
            orders.put(id, updatedOrder);
            return Optional.of(updatedOrder);
        }
        return Optional.empty();
    }

    public Optional<Order> addProductToOrder(UUID orderId, Product product) {
        Order order = orders.get(orderId);
        if (order != null) {
            order.addProduct(product);
            return Optional.of(order);
        }
        return Optional.empty();
    }

    public Optional<Order> removeProductFromOrder(UUID orderId, UUID productId) {
        Order order = orders.get(orderId);
        if (order != null) {
            order.removeProduct(productId);
            return Optional.of(order);
        }
        return Optional.empty();
    }

    public Optional<Order> deleteOrder(UUID id) {
        return Optional.ofNullable(orders.remove(id));
    }
}
