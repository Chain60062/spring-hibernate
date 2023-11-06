package com.vinicius.springudemy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vinicius.springudemy.entities.User;

//@Repository é opcional pois JpaRepository já registra no container
public interface UserRepository extends JpaRepository<User, Long>{

}
