package com.raghavi.insurance.pdf;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.raghavi.insurance.dao.DAOFactory;
import com.raghavi.insurance.dao.RegisterPlanDAO;
import com.raghavi.insurance.dao.UserDAO;
import com.raghavi.insurance.exceptions.PlanCreateExceptions;
import com.raghavi.insurance.pojo.User;

@Controller
@RequestMapping("/insurance/report.pdf")
public class ReportController {
	@Autowired
	DAOFactory daoFactory;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView createReport(HttpServletRequest request) {

		UserDAO userDAO = daoFactory.createUserDAO();
		int userID = Integer.parseInt(request.getParameter("showPDF"));
		User user = userDAO.getUserByUserID(userID);

		Map<String, User> model = new HashMap<String, User>();
		model.put("user", user);

		return new ModelAndView(new PdfReportView(), model);

		// will be passed to the View Page

	}

}
