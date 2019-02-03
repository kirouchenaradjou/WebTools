/**
 * 
 */
package com.raghavi.insurance.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.raghavi.insurance.dao.CaseSheetDAO;
import com.raghavi.insurance.dao.DAOFactory;
import com.raghavi.insurance.dao.RegisterPlanDAO;
import com.raghavi.insurance.dao.UserDAO;
import com.raghavi.insurance.exceptions.PlanCreateExceptions;
import com.raghavi.insurance.pojo.CaseSheet;
import com.raghavi.insurance.pojo.Plan;
import com.raghavi.insurance.pojo.User;

/**
 * @author Raghavi Kirouchenaradjou
 *
 */

@Controller
@RequestMapping("/insurance/*")
public class UserActivityController {

	@Autowired
	DAOFactory daoFactory;

	@RequestMapping(value = "/insurance/selection.htm", method = RequestMethod.POST)
	public ModelAndView activityDropDown(HttpServletRequest request) {

		String action = request.getParameter("activityDropDown");

		if (action.equals("bookAnAppointmnent")) {
			return new ModelAndView("bookAnAppointmnent");
		} else if (action.equals("registerForPlan")) {

			return new ModelAndView("registerForPlan");
		}
		else if (action.equals("checkStatus")) {
			HttpSession session = request.getSession(false);
			String emailID = (String) session.getAttribute("username");
			
			ModelAndView modelAndView = new ModelAndView("checkStatus");
			try
			{
				UserDAO userDAO = new UserDAO();
				User userByEmail = userDAO.getUserByEmailID(emailID);
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("type", "users");
				map.put("user", userByEmail);
				modelAndView.addObject("map", map);
				return modelAndView;
			}
			catch(Exception ex)
			{
				System.out.println(ex.getMessage()+"Error in Check Ststus Controller - Sanction");
			}
			return modelAndView;
		}

		return new ModelAndView();
	}
	//Ajax to retrieve the plan Details
	@RequestMapping(value = "/insurance/getPlanDetails.htm", method = RequestMethod.POST)
	@ResponseBody 
	public String getPlanDetails(HttpServletRequest request) {
		String result="";
		RegisterPlanDAO registerPlanDAO = daoFactory.createPlanDAO();
		int planID = Integer.parseInt(request.getParameter("planID"));
		try {
			Plan planDetails = registerPlanDAO.getPlanDetails(planID);
			result = "<div class='planStyle'> Plan Name :"+planDetails.getPlanName() + "<br>" +
					"<div class='planStyle'> Monthly Payment :"+ planDetails.getMonthly_payment() + "<br>" +
					"<div class='planStyle'> Out Of Pocket :"+ planDetails.getOut_of_pocket() + "<br>" +
					"<div class='planStyle'> Hospital Coverage :"+ planDetails.getHospital_coverage() + "<br>"+
					"<div class='planStyle'> Office Visit? :"+ planDetails.isOffice_visit() + "<br>" +
					"<div class='planStyle'> Rx Covered? :"+ planDetails.isRx_covered() + "<br>";
			return result;
		} catch (PlanCreateExceptions e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	@RequestMapping(value = "/insurance/confirmPlan.htm", method = RequestMethod.POST)
	public String confirmThePlan(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		String emailID = (String) session.getAttribute("username");
		int planSelectionID = Integer.parseInt(request.getParameter("planSelection"));
		RegisterPlanDAO updatePlan = daoFactory.createPlanDAO();
		try {
			boolean success = updatePlan.updatePlanEnrolled(emailID, planSelectionID);
			if(success)
			{
				return "user-dashboard";
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return "error-page";

	}
	@RequestMapping(value = "/insurance/confirmPlan.htm", method = RequestMethod.GET)
	public String getToUserDashboard(HttpServletRequest request) {
		return "user-dashboard";
	}
}
