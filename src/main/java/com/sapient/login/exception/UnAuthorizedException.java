package com.sapient.login.exception;

/**
 * Exception class to throw custom user defined exception
 * 
 * @author spasup
 *
 */
public class UnAuthorizedException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5566312086759558759L;

	public UnAuthorizedException(String message) {
		super(message);
	}

}
