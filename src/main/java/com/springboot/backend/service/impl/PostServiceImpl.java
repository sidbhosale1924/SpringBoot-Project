package com.springboot.backend.service.impl;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.backend.entities.Category;
import com.springboot.backend.entities.Post;
import com.springboot.backend.entities.User;
import com.springboot.backend.exception.ResourceNotFoundException;
import com.springboot.backend.payload.CategoryDto;
import com.springboot.backend.payload.PostDto;
import com.springboot.backend.repositories.CategoryRepo;
import com.springboot.backend.repositories.PostRepo;
import com.springboot.backend.repositories.UserRepo;
import com.springboot.backend.service.IPostService;

@Service
public class PostServiceImpl implements IPostService {

	@Autowired
	private PostRepo postRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private CategoryRepo categoryRepo;
	
	@Override
	public PostDto createPost(PostDto postDto, Integer categoryId, Integer userId) {
		Category cat = this.categoryRepo.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Category ", "Category Id ", categoryId));
		User user = userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User", "ID", userId));
		
		Post post = this.modelMapper.map(postDto, Post.class);
		post.setImageName("default.png");
		post.setAddedDate(new Date());
		post.setCategory(cat);
		post.setUser(user);
		this.postRepo.save(post);
		return this.modelMapper.map(post, PostDto.class);
	}

	@Override
	public Post updatePost(PostDto postDto, Integer postId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deletePost(Integer postId) {
		// TODO Auto-generated method stub

	}

	@Override
	public PostDto getPostById(Integer postId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PostDto> getAllPosts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PostDto> getPostByUser(Integer userId) {
		User user = userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User", "ID", userId));
		List<Post> posts = this.postRepo.findByUser(user);
		List<PostDto> postDtos = posts.stream().map(post-> this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
		return postDtos;
	}

	@Override
	public List<PostDto> getPostByCategory(Integer categoryId) {
		Category cat = this.categoryRepo.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Category ", "Category Id ", categoryId));
		List<Post> categories = this.postRepo.findByCategory(cat);
		List<PostDto> categoriesDto = categories.stream().map(cate-> this.modelMapper.map(cate, PostDto.class)).collect(Collectors.toList());
		return categoriesDto;
	}

}
