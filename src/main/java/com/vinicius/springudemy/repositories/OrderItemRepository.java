package com.vinicius.springudemy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vinicius.springudemy.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{
    
}
