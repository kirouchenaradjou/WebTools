/**
 * 
 */
package com.raghavi.insurance.dao;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.raghavi.insurance.exceptions.PlanCreateExceptions;
import com.raghavi.insurance.pojo.Person;
import com.raghavi.insurance.pojo.Plan;
import com.raghavi.insurance.pojo.User;

/**
 * @author Raghavi Kirouchenaradjou
 *
 */
public class RegisterPlanDAO extends DAO{

	public Plan register(Plan plan) throws PlanCreateExceptions {
		try {
			begin();
			System.out.println("inside DAO");
			Plan plan_data = new Plan(plan.getPlanName(), plan.getMonthly_payment(), plan.getHospital_coverage(), plan.isOffice_visit(), plan.getOut_of_pocket(), plan.isRx_covered());
			getSession().save(plan_data);
			commit();
			return plan;

		} catch (HibernateException e) {
			rollback();
			throw new PlanCreateExceptions("Could not register plan " + plan, e);
		}
	}
	
	public Plan getPlanDetails(int planID) throws PlanCreateExceptions
	{
		try {
			System.out.println("inside getPlanDetails DAO");
			begin();
			Query q=getSession().createQuery("from Plan where planID= :planID");
            q.setInteger("planID",planID);
            Plan plan=(Plan)q.uniqueResult();
            commit();
            return plan;
		}
		catch (HibernateException e) {
			rollback();
			throw new PlanCreateExceptions("Could not get plan " + planID, e);
		}
		
	}
	public boolean updatePlanEnrolled(String email,int planID) throws Exception {
        try {
            begin();
            System.out.println("inside DAO");
            Query q = getSession().createQuery("from Person where userEmail = :useremail");
            q.setString("useremail", email);
            Person person = (Person) q.uniqueResult();
            User user = person.getUser();
            if(user!=null){
                user.setPlan_enrolled(planID);
                getSession().update(user);
                commit();
                return true;
            }else{
                return false;
            }

        } catch (HibernateException e) {
            rollback();
            throw new Exception("Exception while updating the Plan Enrollment: " + e.getMessage());
        }
    
    }
}
