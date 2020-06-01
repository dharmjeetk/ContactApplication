/**
 * 
 */
package com.evolent.backend.service.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * This class handles exception for invalid field length
 * 
 * @author dharmjeet.kumar
 *
 */
@ResponseStatus(value = HttpStatus.EXPECTATION_FAILED, reason = "Field length invalid")
public class FieldLengthInvalidException extends RuntimeException {

	private static final long serialVersionUID = -1239566122366351636L;

	public FieldLengthInvalidException(String fieldName, int minLength, int maxLength) {
		super("Field " + fieldName + " should lie between " + minLength + " & " + maxLength);
	}
}
