package com.springboot.backend.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.backend.entities.Category;
import com.springboot.backend.entities.Post;
import com.springboot.backend.entities.User;

public interface PostRepo extends JpaRepository<Post, Integer>{

	List<Post> findByUser(User user);
	
	List<Post> findByCategory(Category category);
}
