package com.springboot.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.backend.entities.User;

public interface UserRepo extends JpaRepository<User, Integer>{

}
