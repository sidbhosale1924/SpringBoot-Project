package com.springboot.backend.payload;

import java.util.Date;

import com.springboot.backend.entities.Category;
import com.springboot.backend.entities.User;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class PostDto {

	private String postTitle;
	private String content;
	private String imageName;
	private Date addedDate;
	private CategoryDto category;
	private UserDto user;
	
}
