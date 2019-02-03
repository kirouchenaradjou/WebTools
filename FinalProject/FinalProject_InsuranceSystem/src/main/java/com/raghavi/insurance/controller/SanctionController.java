/**
 * 
 */
package com.raghavi.insurance.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.raghavi.insurance.dao.CaseSheetDAO;
import com.raghavi.insurance.dao.DAOFactory;
import com.raghavi.insurance.dao.RegisterPlanDAO;
import com.raghavi.insurance.dao.UserDAO;
import com.raghavi.insurance.exceptions.PlanCreateExceptions;
import com.raghavi.insurance.pojo.Plan;
import com.raghavi.insurance.pojo.User;
import com.raghavi.insurance.utility.SendEmail;

/**
 * @author Raghavi Kirouchenaradjou
 *
 */
@Controller
@RequestMapping("/insurance/*")
public class SanctionController {

	@Autowired
	DAOFactory daoFactory;

	@RequestMapping(value = "/insurance/getMoreDetails.htm", method = RequestMethod.POST)
	@ResponseBody
	public String getPlanDetails(HttpServletRequest request) {
		String result = "";
		UserDAO userDAO = daoFactory.createUserDAO();
		RegisterPlanDAO registerPlanDAO = daoFactory.createPlanDAO();
		int userID = Integer.parseInt(request.getParameter("userID"));
		try {
			User user = userDAO.getUserByUserID(userID);
			Plan planDetails = registerPlanDAO.getPlanDetails(user.getPlan_enrolled());
			result = "<br><strong>User First Name :</strong>"+user.getFirstName() + "<br><strong>Last Name </stroong>" + user.getLastName() + "<br><strong>Address</strong>" + user.getAddress() + "<br>DOB"
					+ user.getDob() + "<br><strong>Credit Card</strong>" + user.getCreditCardNum() + "<br><strong>Hospital Coverage</strong>" + planDetails.getHospital_coverage()
					+ "<br><strong>Monthly Payment</strong>" + planDetails.getMonthly_payment() + "<br><strong>Out Of Pocket</strong>" + planDetails.getOut_of_pocket() + "<br>"
					+ planDetails.getPlanName();

			return result;
		} catch (PlanCreateExceptions e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	@RequestMapping(value = "/insurance/sanctionInsuranceNow.htm", method = RequestMethod.POST)
	@ResponseBody
	public String santionInsurance(HttpServletRequest request) {
		UserDAO userDAO = daoFactory.createUserDAO();
		CaseSheetDAO caseSheetDAO = daoFactory.createCaseSheetDAO();
		int userID = Integer.parseInt(request.getParameter("userID"));
		try {
			User user = userDAO.getUserByUserID(userID);
			user.setAmount_sanctioned(Integer.parseInt(request.getParameter("amount_sanctioned")));
			boolean yesApproved = userDAO.update(user);
			boolean valuUpdated = caseSheetDAO.update(Integer.parseInt(request.getParameter("caseSheetID")));
			String message ="Dear ".concat(user.getFirstName()).concat("/n")+"Hurray! You have been sanctioned the amount";
			SendEmail.sendEmail(user.getPerson().getUserEmail(),message );
			if (yesApproved && valuUpdated)
				return "success";
			else
				return "failedToSanction";
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
}
