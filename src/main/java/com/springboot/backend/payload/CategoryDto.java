package com.springboot.backend.payload;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class CategoryDto {
	
	private Integer categoryId;
	@NotEmpty
	@Size(min = 4, message = "Title should me more than 4 chars.")
	private String categoryTitle;
	@NotEmpty
	@Size(min= 10, message = "Description should be more than 10 chars.")
	private String categoryDescription;

}
