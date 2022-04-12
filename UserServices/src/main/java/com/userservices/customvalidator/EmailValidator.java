package com.userservices.customvalidator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.userservices.dto.UserDTO;
import com.userservices.service.UserService;


public class EmailValidator implements ConstraintValidator<InvalidEmail,UserDTO> {

	@Autowired
	UserService userService;
	
	@Override
	public boolean isValid(UserDTO userDto, ConstraintValidatorContext context) {
		return (userService.isValidUserEmail(userDto));
	}

}
