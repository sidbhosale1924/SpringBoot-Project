package com.springboot.backend.service;

import java.util.List;

import com.springboot.backend.payload.UserDto;

public interface IUserService {
	
	UserDto createUser(UserDto user);
	
	UserDto updateUser(UserDto user, Integer userId);
	
	UserDto getUserById(Integer userId);
	
	List<UserDto> getAllUsers();
	
	void deleteUser(Integer userId);
	
}
