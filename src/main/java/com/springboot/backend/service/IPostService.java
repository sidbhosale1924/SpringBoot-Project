package com.springboot.backend.service;

import java.util.List;

import com.springboot.backend.entities.Post;
import com.springboot.backend.payload.PostDto;

public interface IPostService {
	
	//create
	PostDto createPost(PostDto postDto, Integer categoryId, Integer userId);
	//update
	Post updatePost(PostDto postDto, Integer postId);
	//delete
	void deletePost(Integer postId);
	//get by id
	PostDto getPostById(Integer postId);
	//Get All Posts
	List<PostDto> getAllPosts();
	//Get post by user
	List<PostDto> getPostByUser(Integer userId);
	//get Post by category
	List<PostDto> getPostByCategory(Integer categoryId);

}
