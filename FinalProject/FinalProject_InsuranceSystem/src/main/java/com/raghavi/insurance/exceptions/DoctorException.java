/**
 * 
 */
package com.raghavi.insurance.exceptions;

/**
 * @author Raghavi Kirouchenaradjou
 *
 */
public class DoctorException extends Exception {
	public DoctorException(String message) {
		super("DoctorException-" + message);
	}

	public DoctorException(String message, Throwable cause) {
		super("DoctorException-" + message, cause);
	}
}
