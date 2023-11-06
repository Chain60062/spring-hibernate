package com.vinicius.springudemy.services;

import java.util.List;

import java.util.Optional;
import org.springframework.stereotype.Service;
import com.vinicius.springudemy.entities.Order;
import com.vinicius.springudemy.repositories.OrderRepository;

@Service
public class OrderService {
    private final OrderRepository repository;

    OrderService(OrderRepository repository) {
        this.repository = repository;
    }

    public List<Order> findAll() {
        return repository.findAll();
    }

    public Order findById(Long id) {
        Optional<Order> order = repository.findById(id);
        return order.get();
    }
}
