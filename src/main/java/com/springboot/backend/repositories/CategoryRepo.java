package com.springboot.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.backend.entities.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer>{

}
