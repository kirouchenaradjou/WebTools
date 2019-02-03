/**
 * 
 */
package com.raghavi.insurance.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.raghavi.insurance.exceptions.CaseSheetException;
import com.raghavi.insurance.exceptions.DoctorException;
import com.raghavi.insurance.exceptions.UserBasedException;
import com.raghavi.insurance.pojo.CaseSheet;
import com.raghavi.insurance.pojo.Doctor;
import com.raghavi.insurance.pojo.Person;
import com.raghavi.insurance.pojo.User;

/**
 * @author Raghavi Kirouchenaradjou
 *
 */
public class CaseSheetDAO extends DAO{
	public boolean createCaseSheet(CaseSheet caseSheet) throws Exception {
		try {
			begin();
			System.out.println("inside CaseSheetDAO");
			getSession().save(caseSheet);
			commit();
			return true;
		} catch (HibernateException e) {
			rollback();
			throw new Exception("Exception while creating user: " + e.getMessage());
		}
	}
	public List<CaseSheet> getCaseSheets() throws CaseSheetException {
		try {
			begin();
			Query q = getSession().createQuery("from CaseSheet");
			List<CaseSheet> list = q.list();
			commit();
			return list;
		} catch (HibernateException e) {
			rollback();
			throw new CaseSheetException("Could not list the doctor", e);
		}
	}
	
	public List<CaseSheet> getCaseSheetsByDoctor(long doctorID) throws CaseSheetException {
		try {
			begin();
			Query q = getSession().createQuery("from CaseSheet where doctorID = :doctorID");
			q.setLong("doctorID", doctorID);
			List<CaseSheet> list = q.list();
			commit();
			return list;
		} catch (HibernateException e) {
			rollback();
			throw new CaseSheetException("Could not list the doctor", e);
		}
	}
	
	public boolean update(int casesheetID) throws UserBasedException {
		try {
			begin();
			Query q = getSession().createQuery("from CaseSheet where casesheetID = :casesheetID");
			q.setInteger("casesheetID", casesheetID);
			CaseSheet casesheet = (CaseSheet)q.uniqueResult();
			casesheet.setApproved(true);
			getSession().update(casesheet);
			commit();
			return true;
		} catch (HibernateException e) {
			rollback();
			throw new UserBasedException("Could update the casesheet value", e);
		}
	}
}
