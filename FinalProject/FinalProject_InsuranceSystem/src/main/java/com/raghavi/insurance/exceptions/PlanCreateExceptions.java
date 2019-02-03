/**
 * 
 */
package com.raghavi.insurance.exceptions;

/**
 * @author Raghavi Kirouchenaradjou
 *
 */
public class PlanCreateExceptions extends Exception {
	public PlanCreateExceptions(String message)
	{
		super("PlanCreateExceptions-"+message);
	}
	
	public PlanCreateExceptions(String message, Throwable cause)
	{
		super("PlanCreateExceptions-"+message,cause);
	}
	
}


