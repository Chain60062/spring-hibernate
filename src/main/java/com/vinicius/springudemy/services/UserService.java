package com.vinicius.springudemy.services;

import java.util.List;

import java.util.Optional;
import org.springframework.stereotype.Service;

import com.vinicius.springudemy.entities.User;
import com.vinicius.springudemy.repositories.UserRepository;

@Service
public class UserService {
    private final UserRepository repository;

    UserService(UserRepository repository) {
        this.repository = repository;
    }

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findById(Long id) {
        Optional<User> user = repository.findById(id);
        return user.get();
    }
}
