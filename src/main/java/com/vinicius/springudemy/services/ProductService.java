package com.vinicius.springudemy.services;

import java.util.List;

import java.util.Optional;
import org.springframework.stereotype.Service;
import com.vinicius.springudemy.entities.Product;
import com.vinicius.springudemy.repositories.ProductRepository;

@Service
public class ProductService {
    private final ProductRepository repository;

    ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public List<Product> findAll() {
        return repository.findAll();
    }
    
    public Product findById(Long id) {
        Optional<Product> product = repository.findById(id);
        return product.get();
    }
}
