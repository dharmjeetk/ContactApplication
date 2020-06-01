package com.evolent.backend.service.validator;

/**
 * This is Validator class for validating email id field of contact object
 * 
 * @author dharmjeet.kumar
 *
 */
public class EmailValidator {

	private EmailValidator() {
		// private constructor as we don't want to make any new instance
	}

	public static boolean isValid(String email) {
		String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
		return email.matches(regex);
	}
}
