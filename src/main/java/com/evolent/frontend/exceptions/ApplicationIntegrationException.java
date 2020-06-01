package com.evolent.frontend.exceptions;

/**
 * This is Exception class for handling integration errors in UI
 * 
 * @author dharmjeet.kumar
 *
 */
public class ApplicationIntegrationException extends RuntimeException {

	private static final long serialVersionUID = 3915035547124773012L;

	public ApplicationIntegrationException(String errorMessage) {
		super(errorMessage);
	}

	public ApplicationIntegrationException(String errorMessage, Throwable e) {
		super(errorMessage, e);
	}

}
