package com.evolent.backend.service.validator;

/**
 * This is Validator class for validating length of first name and last name
 * field of contact object
 * 
 * @author dharmjeet.kumar
 *
 */
public class StringLengthValidator {

	private StringLengthValidator() {
		// private constructor as we don't want to make any new instance
	}

	public static boolean isValid(String stringToCheck, int minLength, int maxLength) {
		return stringToCheck.length() >= minLength && stringToCheck.length() <= maxLength;
	}
}
