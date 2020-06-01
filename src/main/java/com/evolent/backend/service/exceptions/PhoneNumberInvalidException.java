/**
 * 
 */
package com.evolent.backend.service.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * This class handles exception for invalid phone number of contact
 * 
 * @author dharmjeet.kumar
 *
 */
@ResponseStatus(value = HttpStatus.EXPECTATION_FAILED, reason = "Phone number invalid")
public class PhoneNumberInvalidException extends RuntimeException {

	private static final long serialVersionUID = -2738733172423284230L;

	public PhoneNumberInvalidException() {
		super("Phone number field has invalid value");
	}
}
