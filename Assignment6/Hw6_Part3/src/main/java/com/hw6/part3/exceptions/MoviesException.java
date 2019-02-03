/**
 * 
 */
package com.hw6.part3.controller.exceptions;

/**
 * @author Raghavi Kirouchenaradjou
 *
 */
public class MoviesException extends Exception {
	public MoviesException(String message) {
		super("MoviesException-" + message);
	}

	public MoviesException(String message, Throwable cause) {
		super("MoviesException-" + message, cause);
	}
}
