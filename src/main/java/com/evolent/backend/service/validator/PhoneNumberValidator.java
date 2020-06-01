package com.evolent.backend.service.validator;

import java.util.regex.Pattern;

/**
 * This is Validator class for validating phone number field of contact object
 * 
 * @author dharmjeet.kumar
 *
 */
public class PhoneNumberValidator {

	private PhoneNumberValidator() {
		// private constructor as we don't want to make any new instance
	}

	public static boolean isValid(String phoneNumber) {
		String patterns = "^(\\+\\d{1,3}( )?)?((\\(\\d{3}\\))|\\d{3})[- .]?\\d{3}[- .]?\\d{4}$"
				+ "|^(\\+\\d{1,3}( )?)?(\\d{3}[ ]?){2}\\d{3}$"
				+ "|^(\\+\\d{1,3}( )?)?(\\d{3}[ ]?)(\\d{2}[ ]?){2}\\d{2}$";

		/*
		 * String[] validPhoneNumbers = { "2055550125", "202 555 0125",
		 * "(202) 555-0125", "+111 (202) 555-0125", "636 856 789", "+111 636 856 789",
		 * "636 85 67 89", "+111 636 85 67 89" };
		 */

		Pattern pattern = Pattern.compile(patterns);
		return pattern.matcher(phoneNumber).matches();
	}
}
