package com.vinicius.springudemy.resources;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vinicius.springudemy.entities.Order;
import com.vinicius.springudemy.services.OrderService;

@RestController
@RequestMapping(value = "/orders")
public class OrderResource {
    private final OrderService service;

    OrderResource(OrderService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Order>> findAll() {
        List<Order> orders = service.findAll();
        return ResponseEntity.ok().body(orders);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Order> findById(@PathVariable Long id) {
        Order order = service.findById(id);
        return ResponseEntity.ok().body(order);
    }
}
