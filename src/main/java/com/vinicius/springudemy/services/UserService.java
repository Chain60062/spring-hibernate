package com.vinicius.springudemy.services;

import java.util.List;

import java.util.Optional;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.vinicius.springudemy.entities.User;
import com.vinicius.springudemy.repositories.UserRepository;
import com.vinicius.springudemy.services.exceptions.DatabaseException;
import com.vinicius.springudemy.services.exceptions.ResourceNotFoundException;

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
        return user.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public User insert(User user) {
        return repository.save(user);
    }

    public void delete(Long id) {
        try {
            if (!repository.existsById(id))
                throw new ResourceNotFoundException(id);
            repository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Database integrity violation when deleting user.");
        }
    }

    public User update(Long id, User updatedUser) {
        User user = repository.getReferenceById(id);
        if (updatedUser.getName() != null)
            user.setName(updatedUser.getName());
        if (updatedUser.getEmail() != null)
            user.setEmail(updatedUser.getEmail());
        if (updatedUser.getPhone() != null)
            user.setPhone(updatedUser.getPhone());

        return repository.save(user);
    }
}
