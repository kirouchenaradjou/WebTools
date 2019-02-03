/**
 * 
 */
package com.raghavi.insurance.exceptions;

/**
 * @author Raghavi Kirouchenaradjou
 *
 */
public class UserBasedException extends Exception {
	public UserBasedException(String message) {
		super("UserBasedException-" + message);
	}

	public UserBasedException(String message, Throwable cause) {
		super("UserBasedException-" + message, cause);
	}
}
