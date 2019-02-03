/**
 * 
 */
package com.raghavi.insurance.controller;

import java.text.SimpleDateFormat;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.captcha.botdetect.web.servlet.Captcha;
import com.raghavi.insurance.dao.PersonDAO;
import com.raghavi.insurance.pojo.Person;
import com.raghavi.insurance.pojo.User;
import com.raghavi.insurance.validator.UserValidator;

/**
 * @author Raghavi Kirouchenaradjou
 *
 */
@Controller
@RequestMapping("/insurance/*")
public class UserController {
	
	/*@Autowired
	@Qualifier("userValidator")
	UserValidator validator;

	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);
	}*/
	
		@RequestMapping(value = "/insurance/userlogin.htm", method = RequestMethod.POST)
		public String handleLoginForm(HttpServletRequest request, PersonDAO personDAO, ModelMap map) {

			String username = request.getParameter("username");
			String password = request.getParameter("password");
			try {
				HttpSession session = request.getSession();
				session.setAttribute("username", username);
				Person u = personDAO.get(username, password);

				if (u != null && u.getStatus() == 1) {
					return "user-dashboard";
				} else if (u != null && u.getStatus() == 0) {
					map.addAttribute("errorMessage", "Please activate your account to login!");
					return "error";
				} else {
					map.addAttribute("errorMessage", "Invalid username/password!");
					return "error";
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return null;

		}

		@RequestMapping(value = "/insurance/userCreate.htm", method = RequestMethod.GET)
		public ModelAndView showCreateForm() {
			return new ModelAndView("user-reg-form", "user", new User());

		}
		
		@RequestMapping(value = "/insurance/userCreate.htm", method = RequestMethod.POST)
		public String handleCreateForm(HttpServletRequest request, @ModelAttribute("user") User user,PersonDAO personDAO, ModelMap map,BindingResult result) {
			
			/*validator.validate(user, result);

			if (result.hasErrors()) {
				return "";
			}*/
			
			Captcha captcha = Captcha.load(request, "CaptchaObject");
			String captchaCode = request.getParameter("captchaCode");
			HttpSession session = request.getSession();
			if (captcha.validate(captchaCode)) {
				System.out.println(user.getFirstName());
				String firstName = request.getParameter("firstName");
				String lastName = request.getParameter("lastName");
				// phoneNumber = Integer.parseInt(request.getParameter("phoneNumber"));
				String address =  request.getParameter("address");
				//Integer creditCardNum = Integer.parseInt(request.getParameter("creditCardNum"));
				String company_name =  request.getParameter("company_name");
				
				Person person = new Person();
				User userAccount = new User(firstName,lastName, user.getPhoneNumber(), address, user.getCreditCardNum(), request.getParameter("dob"), company_name,0,0);
				person.setUserEmail(user.getPerson().getUserEmail());
				person.setPassword(user.getPerson().getPassword());
				person.setRole("user");
				person.setStatus(0);
				
				userAccount.setPerson(person);
				person.setUser(userAccount);

				try {
					Person u = personDAO.register(person);
					Random rand = new Random();
					int randomNum1 = rand.nextInt(5000000);
					int randomNum2 = rand.nextInt(5000000);
					try {
						String str = "http://localhost:8080/insurance/insurance/validateuseremail.htm?email=" + user.getPerson().getUserEmail() + "&key1="
								+ randomNum1 + "&key2=" + randomNum2;
						session.setAttribute("key1", randomNum1);
						session.setAttribute("key2", randomNum2);
						String message ="Dear ".concat(userAccount.getFirstName()).concat("/n")+"Click on this link to activate your account : " + str;
						sendEmail(user.getPerson().getUserEmail(),message );
					} catch (Exception e) {
						System.out.println("Email cannot be sent");
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				map.addAttribute("errorMessage", "Invalid Captcha!");
				return "user-reg-form";
			}

			return "userLogin";
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
				email.setSubject("Insurance Company ");
				email.setMsg(message); // Retrieve email from the DAO and send this
				email.addTo(userEmail);
				email.send();
			} catch (EmailException e) {
				System.out.println("Email cannot be sent");
			}
		}

		@RequestMapping(value = "/insurance/validateuseremail.htm", method = RequestMethod.GET)
		public String validateEmail(HttpServletRequest request, PersonDAO personDAO, ModelMap map) {

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
					boolean updateStatus = personDAO.updateUser(email);
					if (updateStatus) {
						return "userLogin";
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

			return "userLogin";

		}

	}
	

