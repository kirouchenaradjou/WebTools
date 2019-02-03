/**
 * 
 */
package com.raghavi.insurance.dao;

/**
 * @author Raghavi Kirouchenaradjou
 *
 */
public class DAOFactory {

	public RegisterPlanDAO createPlanDAO() {
		return new RegisterPlanDAO();
	}

	public DoctorDAO createDoctorDAO() {
		return new DoctorDAO();
	}
	
	public CaseSheetDAO createCaseSheetDAO() {
		return new CaseSheetDAO();
	}
	
	public UserDAO createUserDAO() {
		return new UserDAO();
	}
}
