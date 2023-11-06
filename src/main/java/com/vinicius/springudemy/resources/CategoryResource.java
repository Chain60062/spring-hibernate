package com.vinicius.springudemy.resources;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vinicius.springudemy.entities.Category;
import com.vinicius.springudemy.services.CategoryService;

@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {
    private final CategoryService service;

    CategoryResource(CategoryService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Category>> findAll(){
        List<Category> categories = service.findAll();
        return ResponseEntity.ok().body(categories);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<Category> findById(@PathVariable Long id){
        Category category = service.findById(id);
        return ResponseEntity.ok().body(category);
    }
}
