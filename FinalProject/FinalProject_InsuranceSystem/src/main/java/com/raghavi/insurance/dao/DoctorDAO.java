/**
 * 
 */
package com.raghavi.insurance.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.raghavi.insurance.exceptions.DoctorException;
import com.raghavi.insurance.pojo.Doctor;
import com.raghavi.insurance.pojo.Person;
import com.raghavi.insurance.pojo.User;

/**
 * @author Raghavi Kirouchenaradjou
 *
 */
public class DoctorDAO extends DAO {

	public List<Doctor> getDoclist(String specialist) throws DoctorException {
		try {
			begin();
			Query q = getSession().createQuery("from Doctor where specialist = :specialist ");
			q.setString("specialist", specialist);
			List<Doctor> list = q.list();
			commit();
			return list;
		} catch (HibernateException e) {
			rollback();
			throw new DoctorException("Could not list the doctor", e);
		}
	}
	
	public List<Doctor> getDoclist() throws DoctorException {
		try {
			begin();
			Query q = getSession().createQuery("from Doctor");
			List<Doctor> list = q.list();
			commit();
			return list;
		} catch (HibernateException e) {
			rollback();
			throw new DoctorException("Could not list the doctor", e);
		}
	}

	public void bookAnAppointment(int doctorID, String emailID) throws Exception {
		try {
			begin();
			UserDAO userDAO = new UserDAO();

			Query q = getSession().createQuery("from Doctor where doctorID = :doctorID");
			q.setInteger("doctorID", doctorID);
			Doctor doctor = (Doctor) q.uniqueResult();
			Query q1 = getSession().createQuery("from Person where userEmail = :useremail");
			q1.setString("useremail", emailID);
			Person person = (Person) q1.uniqueResult();
				User u = person.getUser();
				u.getDoctors().add(doctor);
				getSession().update(u);
				commit();

		} catch (HibernateException ex) {
			rollback();
			System.out.println("Hibernate Excpetion in bookAnAppointment" + ex);
		}
	}
	
	public List<User> getUserList(String emailID) throws Exception {
		try
		{
			begin();
			Query q = getSession().createQuery("from Person where userEmail = :useremail");
			q.setString("useremail", emailID);
			Person person = (Person) q.uniqueResult();
			Doctor doctor = person.getDoctor();
			Set<User> userList = doctor.getUsers();
			ArrayList<User> users = new ArrayList<User>(userList);
			commit();
			return users;
		}
		catch (HibernateException ex) {
			rollback();
			System.out.println("Hibernate Excpetion in bookAnAppointment" + ex);
		}
		return null;
	}
	
	public Doctor getDoctorID(String emailID) throws Exception
	{
		try
		{
			begin();
			Query q = getSession().createQuery("from Person where userEmail = :useremail");
			q.setString("useremail", emailID);
			Person person = (Person) q.uniqueResult();
			Doctor doctor = person.getDoctor();
			commit();
			return doctor;
		}
		catch (HibernateException ex) {
			rollback();
			System.out.println("Hibernate Excpetion in bookAnAppointment" + ex);
		}
		return null;
		
	}
}
