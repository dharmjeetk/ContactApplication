/**
 * 
 */
package com.evolent.backend.service.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * This class handles exception while updating the contact details
 * 
 * @author dharmjeet.kumar
 *
 */
@ResponseStatus(value = HttpStatus.EXPECTATION_FAILED, reason = "Mandatory fields missing")
public class MandatoryFieldsMissingException extends RuntimeException {

	private static final long serialVersionUID = 2722839403814300661L;

	public MandatoryFieldsMissingException(String field) {
		super("Mandatory field [" + field + "] is missing");
	}
}
