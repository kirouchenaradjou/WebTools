/**
 * 
 */
package com.raghavi.insurance.pojo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;


/**
 * @author Raghavi Kirouchenaradjou
 *
 */
@Entity
@Table(name = "person_table")
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "personID", unique = true, nullable = false)
	private long personID;

	@Column(name = "userEmail")
	private String userEmail;

	@Column(name = "password")
	private String password;

	@Column(name = "status")
	private int status;
	
	@Column(name = "role")
	private String role;

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "person", cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private Doctor doctor;
	
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "person", cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private User user;
	
	public Person() {

	}

	
	public Doctor getDoctor() {
		return doctor;
	}


	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String string) {
		this.role = string;
	}


	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}