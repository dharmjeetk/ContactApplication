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
@ResponseStatus(value = HttpStatus.EXPECTATION_FAILED, reason = "Email id invalid")
public class EmailInvalidException extends RuntimeException {

	private static final long serialVersionUID = -1699028695198079527L;

	public EmailInvalidException() {
		super("Email Id field has invalid value");
	}
}
