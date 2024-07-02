package com.example.demo.controller;

import com.example.demo.model.Order;
import com.example.demo.model.Product;
import com.example.demo.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrder(@PathVariable String id) {
        UUID uuid = UUID.fromString(id);
        Optional<Order> order = orderService.getOrderById(uuid);
        return order.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Order> addOrder() {
        Order order = orderService.addOrder();
        return ResponseEntity.ok(order);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Order> updateOrder(@PathVariable String id, @RequestBody Order updatedOrder) {
        UUID uuid = UUID.fromString(id);
        Optional<Order> order = orderService.updateOrder(uuid, updatedOrder);
        return order.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PatchMapping("/{orderId}/products")
    public ResponseEntity<Order> addProductToOrder(@PathVariable String orderId, @RequestBody Product product) {
        UUID uuid = UUID.fromString(orderId);
        Optional<Order> order = orderService.addProductToOrder(uuid, product);
        return order.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{orderId}/products/{productId}")
    public ResponseEntity<Order> removeProductFromOrder(@PathVariable String orderId, @PathVariable String productId) {
        UUID orderUuid = UUID.fromString(orderId);
        UUID productUuid = UUID.fromString(productId);
        Optional<Order> order = orderService.removeProductFromOrder(orderUuid, productUuid);
        return order.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Order> deleteOrder(@PathVariable String id) {
        UUID uuid = UUID.fromString(id);
        Optional<Order> order = orderService.deleteOrder(uuid);
        return order.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}

