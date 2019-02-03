package com.raghavi.insurance.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.raghavi.insurance.pojo.User;

public class UserValidator implements Validator {
	
	public boolean supports(Class aClass) {
		return aClass.equals(User.class);
	}

	public void validate(Object obj, Errors errors) {
		User user = (User) obj;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "error.invalid.user", "First Name Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "error.invalid.user", "Last Name Required");
	/*	ValidationUtils.rejectIfEmptyOrWhitespace(errors, "person.userEmail", "error.invalid.person", "User Name Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "person.password", "error.invalid.person.userEmail", "Password Required");
*/
		
		// check if user exists		
	}
}
