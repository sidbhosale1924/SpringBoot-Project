package com.springboot.backend.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.backend.payload.ApiResponse;
import com.springboot.backend.payload.CategoryDto;
import com.springboot.backend.service.ICategoryService;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

	@Autowired
	private ICategoryService categoryService;
	
	//create
	@PostMapping("/create")
	public ResponseEntity<CategoryDto> createCtegory(@Valid @RequestBody CategoryDto categoryDto){
		CategoryDto category = categoryService.createCategory(categoryDto);
		return new ResponseEntity<CategoryDto>(category, HttpStatus.CREATED);
	}
	
	//update
	@PutMapping("/update/{catId}")
	public ResponseEntity<CategoryDto> updateCategory(@Valid @RequestBody CategoryDto categoryDto, @PathVariable("catId") int catId){
		CategoryDto updateCategory = categoryService.updateCategory(categoryDto, catId);
		return new ResponseEntity<CategoryDto>(updateCategory, HttpStatus.OK);
	}
	
	//delete
	@DeleteMapping("/delete/{catId}")
	public ResponseEntity<ApiResponse> deleteCategory(@PathVariable("catId") int catId){
		categoryService.deleteCategory(catId);
		return new ResponseEntity(new ApiResponse("User deleted Successfully.", true), HttpStatus.OK);
	}
	
	//Get
	@GetMapping("/{catId}")
	public ResponseEntity<CategoryDto> getCategory(@PathVariable("catId") int catId){
		CategoryDto categoryDto = categoryService.getCategoryById(catId);
		return new ResponseEntity<CategoryDto>(categoryDto,HttpStatus.OK);
	}
	
	//Get All
	@GetMapping("/")
	public ResponseEntity<List<CategoryDto>> getAllCategories(){
		List<CategoryDto> allCategory = categoryService.getAllCategory();
		return new ResponseEntity<List<CategoryDto>>(allCategory, HttpStatus.OK);
	}
}
