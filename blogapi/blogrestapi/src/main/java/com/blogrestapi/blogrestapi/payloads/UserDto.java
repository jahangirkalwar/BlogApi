package com.blogrestapi.blogrestapi.payloads;

import javax.validation.constraints.Email;



import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class UserDto {
	
	private int id;
	
	@NotEmpty
	@Size(min=4,message="username must be minimum of 4 characters.")
	private String name;
	
	@Email(message = "your email valid is not valid.")
	private String email;
	
	@NotEmpty
	@Size(min=5, max=16, message = "password must have a value between 5 and 16 characters!")
	@Pattern(regexp ="(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,}",
			 message = "Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters")
	private String password;
	
	@NotEmpty	
	private String about;
}
