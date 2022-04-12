package com.userservices.customvalidator;

import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class RoleValidator implements ConstraintValidator<InvalidRole, List<String>> {

	@Override
	public boolean isValid(List<String> roles, ConstraintValidatorContext context) {
		return roles.size() >= 1;
	}

}
