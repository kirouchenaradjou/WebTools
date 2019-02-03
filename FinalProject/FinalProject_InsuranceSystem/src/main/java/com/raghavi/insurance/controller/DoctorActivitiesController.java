/**
 * 
 */
package com.raghavi.insurance.controller;

import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.raghavi.insurance.dao.CaseSheetDAO;
import com.raghavi.insurance.dao.DAOFactory;
import com.raghavi.insurance.dao.DoctorDAO;
import com.raghavi.insurance.pojo.CaseSheet;
import com.raghavi.insurance.pojo.Doctor;
import com.raghavi.insurance.pojo.User;

/**
 * @author Raghavi Kirouchenaradjou
 *
 */
@Controller
@RequestMapping("/insurance/*")
public class DoctorActivitiesController {

	@Autowired
	DAOFactory daoFactory;

	@RequestMapping(value = "/insurance/getUserList.htm", method = RequestMethod.POST)
	@ResponseBody
	public String createAPlan(HttpServletRequest request) {
		String userID = request.getParameter("userID");
		HttpSession session = request.getSession();
		String emailID = (String) session.getAttribute("username");
		DoctorDAO doctor = daoFactory.createDoctorDAO();
		CaseSheetDAO caseSheetDAO = daoFactory.createCaseSheetDAO();
		String caseSheetDetails = request.getParameter("caseSheetID");
		try {
			Doctor doctorID = doctor.getDoctorID(emailID);
			CaseSheet caseSheet = new CaseSheet(Integer.parseInt(userID), doctorID.getDoctorID(), caseSheetDetails,false);
			boolean success = caseSheetDAO.createCaseSheet(caseSheet);
			
			if (success)
				return "success";
			else
				return "fail";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}
}
