/**
 * 
 */
package com.raghavi.insurance.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.captcha.botdetect.web.servlet.Captcha;
import com.raghavi.insurance.dao.CaseSheetDAO;
import com.raghavi.insurance.dao.DAOFactory;
import com.raghavi.insurance.dao.DoctorDAO;
import com.raghavi.insurance.dao.PersonDAO;
import com.raghavi.insurance.pojo.CaseSheet;
import com.raghavi.insurance.pojo.Doctor;
import com.raghavi.insurance.pojo.Person;
import com.raghavi.insurance.pojo.User;

/**
 * @author Raghavi Kirouchenaradjou
 *
 */
@Controller
@RequestMapping("/insurance/*")
public class DoctorController {

	@Autowired
	DAOFactory daoFactory;

	@RequestMapping(value = "/insurance/doclogin.htm", method = RequestMethod.POST)
	public ModelAndView handleLoginForm(HttpServletRequest request, PersonDAO personDAO, ModelMap map) {

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		try {
			HttpSession session = request.getSession(true);
			session.setAttribute("username", username);
			Person u = personDAO.get(username, password);

			if (u != null && u.getStatus() == 1) {
				ModelAndView modelAndView = new ModelAndView("doctor-dashboard");
				List<User> userList = new ArrayList<User>();
				try {
					Set<User> userListDetails = u.getDoctor().getUsers();
					userList = new ArrayList<User>(userListDetails);
				} catch (Exception e) {
					e.printStackTrace();
				}
				Map<String, Object> map1 = new HashMap<String, Object>();
				map1.put("type", "userList");
				map1.put("users", userList);
				modelAndView.addObject("map1", map1);
				return modelAndView;

			} else if (u != null && u.getStatus() == 0) {
				map.addAttribute("errorMessage", "Please activate your account to login!");
				return new ModelAndView("error-page");
			} else {
				map.addAttribute("errorMessage", "Invalid username/password!");
				return new ModelAndView("error-page");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;

	}

	@RequestMapping(value = "/insurance/docCreate.htm", method = RequestMethod.GET)
	public String showCreateForm() {

		return "doc-reg-form";
	}

	@RequestMapping(value = "/insurance/showHistory.htm", method = RequestMethod.GET)
	public ModelAndView showHistory(HttpServletRequest request) {
		List<CaseSheet> caseSheets = new ArrayList<CaseSheet>();

		ModelAndView modelAndView = new ModelAndView("showHistory");
		HttpSession session = request.getSession();
		String emailID = (String) session.getAttribute("username");
		try {
			DoctorDAO doctorDAO = daoFactory.createDoctorDAO();
			Doctor doc = doctorDAO.getDoctorID(emailID);
			CaseSheetDAO caseSheetDAO = daoFactory.createCaseSheetDAO();
			caseSheets = caseSheetDAO.getCaseSheetsByDoctor(doc.getDoctorID());
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("type", "caseSheets");
			map.put("cases", caseSheets);
			modelAndView.addObject("map", map);
			return modelAndView;
		} catch (Exception ex) {
			System.out.println(ex);
		}
		return modelAndView;
	}

	@RequestMapping(value = "/insurance/docCreate.htm", method = RequestMethod.POST)
	public String handleCreateForm(HttpServletRequest request, PersonDAO personDAO, ModelMap map) {
		Captcha captcha = Captcha.load(request, "CaptchaObject");
		String captchaCode = request.getParameter("captchaCode");
		HttpSession session = request.getSession();
		if (captcha.validate(captchaCode)) {
			String useremail = request.getParameter("username");
			String password = request.getParameter("password");
			String firstName = request.getParameter("firstName");
			String lastName = request.getParameter("lastName");
			Integer phoneNumber = Integer.parseInt(request.getParameter("phoneNumber"));
			String specialist = request.getParameter("specialist");
			String address = request.getParameter("address");
			String medical_education = request.getParameter("medical_education");
			Integer depositCardNo = Integer.parseInt(request.getParameter("depositCardNo"));
			Integer routingNo = Integer.parseInt(request.getParameter("routingNo"));
			Person person = new Person();
			Doctor doctor = new Doctor(firstName, lastName, phoneNumber, specialist, address, medical_education,
					depositCardNo, routingNo, request.getParameter("dob"));
			person.setUserEmail(useremail);
			person.setPassword(password);
			person.setRole("doctor");
			person.setStatus(0);
			doctor.setPerson(person);
			person.setDoctor(doctor);

			try {
				Person u = personDAO.register(person);
				Random rand = new Random();
				int randomNum1 = rand.nextInt(5000000);
				int randomNum2 = rand.nextInt(5000000);
				try {
					String str = "http://localhost:8080/insurance/insurance/validateemail.htm?email=" + useremail
							+ "&key1=" + randomNum1 + "&key2=" + randomNum2;
					session.setAttribute("key1", randomNum1);
					session.setAttribute("key2", randomNum2);
					sendEmail(useremail, "Click on this link to activate your account : " + str);
				} catch (Exception e) {
					System.out.println("Email cannot be sent");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			map.addAttribute("errorMessage", "Invalid Captcha!");
			return "doc-reg-form";
		}

		return "doctorLogin";
	}

	/**
	 * @param userEmail
	 * @param string
	 */
	public void sendEmail(String userEmail, String message) {
		try {
			Email email = new SimpleEmail();
			email.setHostName("smtp.googlemail.com");
			email.setSmtpPort(465);
			email.setAuthenticator(new DefaultAuthenticator("contactapplication2018@gmail.com", "springmvc"));
			email.setSSLOnConnect(true);
			email.setFrom("no-reply@msis.neu.edu"); // This user email does not
													// exist
			email.setSubject("Web tools lab ");
			email.setMsg(message); // Retrieve email from the DAO and send this
			email.addTo(userEmail);
			email.send();
		} catch (EmailException e) {
			System.out.println("Email cannot be sent");
		}
	}

	@RequestMapping(value = "/insurance/validateemail.htm", method = RequestMethod.GET)
	public String validateEmail(HttpServletRequest request, PersonDAO personDao, ModelMap map) {

		// The user will be sent the following link when the use registers
		// This is the format of the email
		// http://hostname:8080/lab10/user/validateemail.htm?email=useremail&key1=<random_number>&key2=<body
		// of the email that when user registers>
		HttpSession session = request.getSession();
		String email = request.getParameter("email");
		int key1 = Integer.parseInt(request.getParameter("key1"));
		int key2 = Integer.parseInt(request.getParameter("key2"));
		System.out.println(session.getAttribute("key1"));
		System.out.println(session.getAttribute("key2"));

		if ((Integer) (session.getAttribute("key1")) == key1 && ((Integer) session.getAttribute("key2")) == key2) {
			try {
				System.out.println("HI________");
				boolean updateStatus = personDao.updateUser(email);
				if (updateStatus) {
					return "doctorLogin";
				} else {

					return "error";
				}

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			map.addAttribute("errorMessage", "Link expired , generate new link");
			map.addAttribute("resendLink", true);
			return "error";
		}

		return "doctorLogin";

	}

	@RequestMapping(value = "/insurance/forgotpassword.htm", method = RequestMethod.GET)
	public String forgotPassword() {

		return "forgot-password";
	}

	@RequestMapping(value = "/insurance/forgotpassword.htm", method = RequestMethod.POST)
	public String handleForgotPasswordForm(HttpServletRequest request, PersonDAO personDAO) {

		String useremail = request.getParameter("useremail");
		Captcha captcha = Captcha.load(request, "CaptchaObject");
		String captchaCode = request.getParameter("captchaCode");

		if (captcha.validate(captchaCode)) {
			Person user = personDAO.get(useremail);
			sendEmail(useremail, "Your password is : " + user.getPassword());
			return "forgot-password-success";
		} else {
			request.setAttribute("captchamsg", "Captcha not valid");
			return "forgot-password";
		}
	}

}
