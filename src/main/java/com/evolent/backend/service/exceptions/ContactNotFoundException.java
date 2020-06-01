/**
 * 
 */
package com.evolent.backend.service.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * This class handles exception when contact not found in system
 * 
 * @author dharmjeet.kumar
 *
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Contact  Not Found")
public class ContactNotFoundException extends Exception {

	private static final long serialVersionUID = -3332292346834265371L;

	public ContactNotFoundException(int contactId) {
		super("ContactNotFoundException with contactId =" + contactId);
	}
}
