package com.vinicius.springudemy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vinicius.springudemy.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{
    
}
