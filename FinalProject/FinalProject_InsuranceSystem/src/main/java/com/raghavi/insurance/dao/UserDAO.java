/**
 * 
 */
package com.raghavi.insurance.dao;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.omg.CORBA.UserException;

import com.raghavi.insurance.exceptions.UserBasedException;
import com.raghavi.insurance.pojo.Person;
import com.raghavi.insurance.pojo.User;

/**
 * @author Raghavi Kirouchenaradjou
 *
 */
public class UserDAO extends DAO {

	public boolean update(User user) throws UserBasedException {
		try {
			begin();
			getSession().update(user);
			commit();
			return true;
		} catch (HibernateException e) {
			rollback();
			throw new UserBasedException("Could not save the category", e);
		}
	}

	/**
	 * @param emailID
	 * @return
	 */
	public User getUserByEmailID(String emailID) {
		try {
			begin();
			Query q = getSession().createQuery("from Person where userEmail = :useremail");
			q.setString("useremail", emailID);
			Person person = (Person) q.uniqueResult();
			User user = person.getUser();
			commit();
			return user ;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;

	}
	
	public User getUserByUserID(int userID) {
		try {
			begin();
			Query q = getSession().createQuery("from User where userID = :userID");
			q.setInteger("userID", userID);
			User user = (User) q.uniqueResult();
			commit();
			return user;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;

	}
}
