package com.springboot.backend.service;

import java.util.List;

import com.springboot.backend.payload.CategoryDto;

public interface ICategoryService {
	
	//create
	CategoryDto createCategory(CategoryDto categoryDto);
	
	//update
	CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId);
	
	//delete
	void deleteCategory(Integer categoryId);
	
	//getCategory
	CategoryDto getCategoryById(Integer categoryId);
	
	//getAll
	List<CategoryDto> getAllCategory();
}
