package com.springboot.backend.payload;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {

	private int id;
	@NotEmpty
	@Size(min = 4, message = "Name should not me less than 4 chars !!")
	private String name;
	@Email(message = "Your email is not valid !!")
	private String email;
	@NotEmpty
	@Size(min = 5, max = 15, message = "Password should be greater than 5 chars and less than 15 chars !!")
	private String password;
	@NotEmpty
	private String about;
	
}
