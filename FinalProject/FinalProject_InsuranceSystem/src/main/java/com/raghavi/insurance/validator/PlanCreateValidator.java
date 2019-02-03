/**
 * 
 */
package com.raghavi.insurance.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.raghavi.insurance.pojo.Plan;

/**
 * @author Raghavi Kirouchenaradjou
 *
 */
public class PlanCreateValidator implements Validator {
	public boolean supports(Class aClass) {
		return aClass.equals(Plan.class);
	}

	public void validate(Object obj, Errors errors) {
		Plan plan = (Plan) obj;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "planName", "error.invalid.planName", "Plane Name Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "monthly_payment", "error.invalid.monthly_payment", "monthly_payment Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "hospital_coverage", "error.invalid.hospital_coverage", "Hospital Coverage Name Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "office_visit", "error.invalid.office_visit", "office_visit Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "out_of_pocket", "error.invalid.out_of_pocket", "out_of_pocket Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "rx_covered", "error.invalid.rx_covered", "rx_covered Required");

	}
}
