/**
 * 
 */
package com.raghavi.insurance.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Raghavi Kirouchenaradjou
 *
 */
@Entity
@Table(name="casesheet")
public class CaseSheet {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "casesheetID")
	private int casesheetID;
	
	@Column(name="userID")
	private int userID;
	
	@Column(name="doctorID")
	private long doctorID;
	
	@Column(name="casesheet_details")
	private String casesheet_details;

	@Column(name="approved")
	private boolean approved;
	
	public int getCasesheetID() {
		return casesheetID;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public long getDoctorID() {
		return doctorID;
	}

	public void setDoctorID(int doctorID) {
		this.doctorID = doctorID;
	}

	public String getCasesheet_details() {
		return casesheet_details;
	}

	public void setCasesheet_details(String casesheet_details) {
		this.casesheet_details = casesheet_details;
	}

	

	public void setDoctorID(long doctorID) {
		this.doctorID = doctorID;
	}
	
	

	public boolean isApproved() {
		return approved;
	}

	public void setApproved(boolean approved) {
		this.approved = approved;
	}

	/**
	 * @param userID
	 * @param doctorID
	 * @param casesheet_details
	 */
	public CaseSheet(int userID, long doctorID, String casesheet_details,boolean approved) {
		this.userID = userID;
		this.doctorID = doctorID;
		this.casesheet_details = casesheet_details;
		this.approved = approved;
	}
	
	public CaseSheet()
	{
		
	}
}
