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
@Table(name="plan_details")
public class Plan {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "planID")
	private int planID;
	
	@Column(name="planName")
	private String planName;
	
	@Column(name="monthly_payment")
	private int monthly_payment;
	
	@Column(name="hospital_coverage")
	private String hospital_coverage;
	
	@Column(name="office_visit")
	private boolean office_visit;
	
	@Column(name="out_of_pocket")
	private int out_of_pocket;
	
	@Column(name="rx_covered")
	private boolean rx_covered;

	public String getPlanName() {
		return planName;
	}

	public void setPlanName(String planName) {
		this.planName = planName;
	}

	public int getMonthly_payment() {
		return monthly_payment;
	}

	public void setMonthly_payment(int monthly_payment) {
		this.monthly_payment = monthly_payment;
	}

	public String getHospital_coverage() {
		return hospital_coverage;
	}

	public void setHospital_coverage(String hospital_coverage) {
		this.hospital_coverage = hospital_coverage;
	}

	public boolean isOffice_visit() {
		return office_visit;
	}

	public void setOffice_visit(boolean office_visit) {
		this.office_visit = office_visit;
	}

	public int getOut_of_pocket() {
		return out_of_pocket;
	}

	public void setOut_of_pocket(int out_of_pocket) {
		this.out_of_pocket = out_of_pocket;
	}

	public boolean isRx_covered() {
		return rx_covered;
	}

	public void setRx_covered(boolean rx_covered) {
		this.rx_covered = rx_covered;
	}

	
	/**
	 * @param planName
	 * @param monthly_payment
	 * @param hospital_coverage
	 * @param office_visit
	 * @param out_of_pocket
	 * @param rx_covered
	 */
	public Plan(String planName, int monthly_payment, String hospital_coverage, boolean office_visit, int out_of_pocket,
			boolean rx_covered) {
		this.planName = planName;
		this.monthly_payment = monthly_payment;
		this.hospital_coverage = hospital_coverage;
		this.office_visit = office_visit;
		this.out_of_pocket = out_of_pocket;
		this.rx_covered = rx_covered;
	}


	public Plan() {
	}
	
	
}
