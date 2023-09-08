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
import com.springboot.backend.payload.UserDto;
import com.springboot.backend.service.IUserService;

@RestController
@RequestMapping("/api/user")
public class UserController {
	
	@Autowired
	private IUserService userService;
	
	//Create new user in database
	@PostMapping("/create")
	public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto){
		UserDto createdUser = this.userService.createUser(userDto);
		return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
	}
	
	//Update existing user
	@PutMapping("/{userId}")
	public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto userDto, @PathVariable("userId") Integer userId){
		UserDto updateUser = this.userService.updateUser(userDto, userId);
		return ResponseEntity.ok(updateUser);
	}
	
	//Delete existing user
	@DeleteMapping("/{userId}")
	public ResponseEntity<ApiResponse> deleteUser(@PathVariable("userId") Integer userId){
		this.userService.deleteUser(userId);
		return new ResponseEntity(new ApiResponse("User deleted Successfully.", true), HttpStatus.OK);
	}
	
	//Get all users from database
	@GetMapping("/users")
	public ResponseEntity<List<UserDto>> getAllUsrs(){
		List<UserDto> allUsers = this.userService.getAllUsers();
		return ResponseEntity.ok(allUsers);
	}
	
	//Get user with id
	@GetMapping("/{userId}")
	public ResponseEntity<UserDto> getUserWithId(@PathVariable("userId") Integer userId){
		UserDto userById = this.userService.getUserById(userId);
		return ResponseEntity.ok(userById);
	}

}
