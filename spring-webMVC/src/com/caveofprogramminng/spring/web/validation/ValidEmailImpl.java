package com.caveofprogramminng.spring.web.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidEmailImpl implements ConstraintValidator<ValidEmail, String> {

	private int min;
	
	@Override
	public void initialize(ValidEmail constraintAnnotation) {
		// TODO Auto-generated method stub
		
		min = constraintAnnotation.min();
		
	}

	@Override
	public boolean isValid(String emai, ConstraintValidatorContext context) {
		// TODO Auto-generated method stub
		
		if(emai.length()>=min) {
			return true;
		}
		else
		return false;
	}
	
	
	
}
