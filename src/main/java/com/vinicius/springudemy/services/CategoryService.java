package com.vinicius.springudemy.services;

import java.util.List;

import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.vinicius.springudemy.entities.Category;
import com.vinicius.springudemy.repositories.CategoryRepository;

@Service
public class CategoryService {
    private final CategoryRepository repository;

    CategoryService(CategoryRepository repository) {
        this.repository = repository;
    }
    @GetMapping
    public List<Category> findAll() {
        return repository.findAll();
    }
    @GetMapping(value = "/{id}")
    public Category findById(Long id) {
        Optional<Category> category = repository.findById(id);
        return category.get();
    }
}
