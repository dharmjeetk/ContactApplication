/**
 * 
 */
package com.evolent.backend.service.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * This class handles exception for invalid email id of contact
 * 
 * @author dharmjeet.kumar
 *
 */
@ResponseStatus(value = HttpStatus.EXPECTATION_FAILED, reason = "Contact status invalid")
public class ContactStatusInvalidException extends RuntimeException {

	private static final long serialVersionUID = -3101359664740481918L;

	public ContactStatusInvalidException() {
		super("Contact field has invalid value");
	}

	public ContactStatusInvalidException(String errorMessage) {
		super(errorMessage);
	}
}
