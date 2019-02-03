/**
 * 
 */
package com.raghavi.insurance.pojo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


/**
 * @author Raghavi Kirouchenaradjou
 *
 */

@Entity
@Table(name = "user_table")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "userID")
	private long userID;

	@Column(name = "firstName")
	private String firstName;

	@Column(name = "lastName")
	private String lastName;
	
	@Column(name = "phoneNumber")
	private int phoneNumber;
	

	@Column(name = "address")
	private String address;

	@Column(name = "creditCardNum")
	private int creditCardNum;
	
	@Column(name = "dob")
	private String dob;
	
	@Column(name="company_name")
	private String company_name;
	
	@Column(name="plan_enrolled")
	private int plan_enrolled;
	
	@Column(name="amount_sanctioned")
	private int amount_sanctioned;
	
	@OneToOne
	@JoinColumn (name = "personID")
	private Person person;

	@ManyToMany
    @JoinTable (
       name="user_doctor_table",
       joinColumns = {@JoinColumn(name="userID", nullable = false, updatable = false)},
       inverseJoinColumns = {@JoinColumn(name="doctorID" )}
    )
	private Set<Doctor> doctors = new HashSet<Doctor>();

	
	public Set<Doctor> getDoctors() {
		return doctors;
	}

	public void setDoctors(Set<Doctor> doctors) {
		this.doctors = doctors;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
	


	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getCreditCardNum() {
		return creditCardNum;
	}

	public void setCreditCardNum(int creditCardNum) {
		this.creditCardNum = creditCardNum;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getCompany_name() {
		return company_name;
	}

	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}

	public int getPlan_enrolled() {
		return plan_enrolled;
	}

	public void setPlan_enrolled(int plan_enrolled) {
		this.plan_enrolled = plan_enrolled;
	}

	
	public long getUserID() {
		return userID;
	}

	

	public int getAmount_sanctioned() {
		return amount_sanctioned;
	}

	public void setAmount_sanctioned(int amount_sanctioned) {
		this.amount_sanctioned = amount_sanctioned;
	}

	/**
	 * @param firstName
	 * @param lastName
	 * @param phoneNumber
	 * @param address
	 * @param creditCardNum
	 * @param dob
	 * @param company_name
	 */
	public User(String firstName, String lastName, int phoneNumber, String address, int creditCardNum, String dob,
			String company_name,int plan_enrolled,int amount_sanctioned) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.creditCardNum = creditCardNum;
		this.dob = dob;
		this.company_name = company_name;
		this.plan_enrolled = plan_enrolled;
		this.amount_sanctioned = amount_sanctioned;
	}

	public User()
	{
		
	}
	
	@Override 
	public String toString(){
		return firstName.concat(" ").concat(lastName);
	}
	
}
