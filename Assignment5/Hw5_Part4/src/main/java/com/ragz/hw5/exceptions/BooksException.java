/**
 * 
 */
package com.ragz.hw5.exceptions;

/**
 * @author Raghavi Kirouchenaradjou
 *
 */
public class BooksException extends Exception {
	public BooksException(String message) {
		super("BooksException-" + message);
	}

	public BooksException(String message, Throwable cause) {
		super("BooksException-" + message, cause);
	}
}
