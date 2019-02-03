/**
 * 
 */
package com.raghavi.insurance.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Raghavi Kirouchenaradjou
 *
 */
@Controller
public class LoginController {
	
	@RequestMapping(value = "/insurance/login.htm", method = RequestMethod.GET)
	public String showLoginForm() {

		return "mainPage";
	}
	
	@RequestMapping(value = "/insurance/admin.htm", method = RequestMethod.GET)
	public String showAdminPanel() {

		return "adminPanel";
	}
	
	@RequestMapping(value = "/insurance/userMainPage.htm", method = RequestMethod.GET)
	public String showUserPanel() {

		return "userLogin";
	}
	
	@RequestMapping(value = "/insurance/doctorMainPage.htm", method = RequestMethod.GET)
	public String showDoctorPanel() {

		return "doctorLogin";
	}
	
	@RequestMapping(value = "/insurance/logOff.htm", method = RequestMethod.GET)
	public String showLoginFormAfterLogOff(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		session.invalidate();
		return "mainPage";
	}

	/*@RequestMapping(value = "/insurance/login.htm", method = RequestMethod.POST)
	public ModelAndView selectMovie(HttpServletRequest request) {

		String action = request.getParameter("loginDropDown");

		if (action.equals("doctorLogin")) {
			return new ModelAndView("doctorLogin");
		} else if (action.equals("userLogin")) {

			return new ModelAndView("userLogin");
		}
		else if (action.equals("adminPanel"))
		{
			return new ModelAndView("adminPanel");
		}

		return new ModelAndView();
	}*/
}
