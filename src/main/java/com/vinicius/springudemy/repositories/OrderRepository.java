package com.vinicius.springudemy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vinicius.springudemy.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{
    
}
