/**
 * 
 */
package com.raghavi.insurance.exceptions;

/**
 * @author Raghavi Kirouchenaradjou
 *
 */
public class CaseSheetException extends Exception {
	public CaseSheetException(String message) {
		super("CaseSheetException-" + message);
	}

	public CaseSheetException(String message, Throwable cause) {
		super("CaseSheetException-" + message, cause);
	}
}
