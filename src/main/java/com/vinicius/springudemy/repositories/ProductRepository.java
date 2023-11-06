package com.vinicius.springudemy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vinicius.springudemy.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
    
}
