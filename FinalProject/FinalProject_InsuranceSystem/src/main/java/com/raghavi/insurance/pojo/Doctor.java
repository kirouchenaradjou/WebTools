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
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


/**
 * @author Raghavi Kirouchenaradjou
 *
 */
@Entity
@Table(name = "doctor_table")
public class Doctor {


	//@GenericGenerator(name = "generator", strategy = "foreign", parameters = @Parameter(name = "property", value = "person"))
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "doctorID")//, unique = true, nullable = false)
	private long doctorID;

	@Column(name = "firstName")
	private String firstName;

	@Column(name = "lastName")
	private String lastName;
	
	@Column(name = "phoneNumber")
	private int phoneNumber;
	
	@Column(name = "specialist")
	private String specialist;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "medical_education")
	private String medical_education;
	
	@Column(name = "depositCardNo")
	private int depositCardNo;
	
	@Column(name = "routingNo")
	private int routingNo;
	
	@Column(name = "dob")
	private String dob;
	
	

	@OneToOne
	@JoinColumn (name = "personID")
	private Person person; 

	@ManyToMany(mappedBy="doctors")
	private Set<User> users = new HashSet<User>();
	
	
	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}


	
	/**
	 * @param firstName
	 * @param lastName
	 * @param phoneNumber
	 * @param specialist
	 * @param address
	 * @param medical_education
	 * @param depositCardNo
	 * @param routingNo
	 */
	public Doctor(String firstName, String lastName, int phoneNumber, String specialist, String address,
			String medical_education, int depositCardNo, int routingNo,String dob) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.specialist = specialist;
		this.address = address;
		this.medical_education = medical_education;
		this.depositCardNo = depositCardNo;
		this.routingNo = routingNo;
		this.dob = dob;
	}

	
	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getSpecialist() {
		return specialist;
	}

	public void setSpecialist(String specialist) {
		this.specialist = specialist;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMedical_education() {
		return medical_education;
	}

	public void setMedical_education(String medical_education) {
		this.medical_education = medical_education;
	}

	public int getDepositCardNo() {
		return depositCardNo;
	}

	public void setDepositCardNo(int depositCardNo) {
		this.depositCardNo = depositCardNo;
	}

	public int getRoutingNo() {
		return routingNo;
	}

	public void setRoutingNo(int routingNo) {
		this.routingNo = routingNo;
	}

	public Doctor() {
		
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
	
	
	public long getDoctorID() {
		return doctorID;
	}


	@Override 
	public String toString(){
		return firstName.concat(" ").concat(lastName);
	}

}
