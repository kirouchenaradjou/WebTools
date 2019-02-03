/**
 * 
 */
package com.raghavi.insurance.dao;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.raghavi.insurance.pojo.Doctor;
import com.raghavi.insurance.pojo.Person;

/**
 * @author Raghavi Kirouchenaradjou
 *
 */
public class PersonDAO extends DAO {
	public Person register(Person u) throws Exception {
		try {
			begin();
			System.out.println("inside DAO");
			getSession().save(u);
			commit();
			return u;

		} catch (HibernateException e) {
			rollback();
			throw new Exception("Exception while creating user: " + e.getMessage());
		}
	}
	public boolean updateUser(String email) throws Exception {
        try {
            begin();
            System.out.println("inside DAO");
            Query q = getSession().createQuery("from Person where userEmail = :useremail");
            q.setString("useremail", email);
            Person person = (Person) q.uniqueResult();
            if(person!=null){
                person.setStatus(1);
                getSession().update(person);
                commit();
                return true;
            }else{
                return false;
            }

        } catch (HibernateException e) {
            rollback();
            throw new Exception("Exception while creating user: " + e.getMessage());
        }
    
    }
	/**
	 * @param username
	 * @param password
	 * @return
	 */
	public Person get(String userEmail, String password) throws Exception {
        try {
            begin();
            Query q = getSession().createQuery("from Person where userEmail = :useremail and password = :password");
            q.setString("useremail", userEmail);
            q.setString("password", password);            
            Person person = (Person) q.uniqueResult();
            commit();
            return person;
        } catch (HibernateException e) {
            rollback();
            throw new Exception("Could not get user " + userEmail, e);
        }
    }
	
	public Person get(String userEmail){
        try {
            begin();
            Query q = getSession().createQuery("from Person where userEmail = :useremail");
            q.setString("useremail", userEmail);
            Person person = (Person) q.uniqueResult();
            commit();
            return person;
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
            return null;
        
    }

}
