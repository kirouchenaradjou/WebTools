/**
 * 
 */
package com.raghavi.insurance.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

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

import com.raghavi.insurance.dao.CaseSheetDAO;
import com.raghavi.insurance.dao.DAOFactory;
import com.raghavi.insurance.dao.RegisterPlanDAO;
import com.raghavi.insurance.exceptions.PlanCreateExceptions;
import com.raghavi.insurance.pojo.CaseSheet;
import com.raghavi.insurance.pojo.Plan;
import com.raghavi.insurance.pojo.User;
import com.raghavi.insurance.validator.PlanCreateValidator;

/**
 * @author Raghavi Kirouchenaradjou
 *
 */
@Controller
@RequestMapping("/insurance/*")
public class AdminController {
	
	@Autowired
	@Qualifier("planCreateValidator")
	PlanCreateValidator planCreateValidator;

	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(planCreateValidator);
	}
	@Autowired
	DAOFactory daoFactory;
	
	@RequestMapping(value = "/insurance/createAPlan.htm", method = RequestMethod.GET)
	public ModelAndView createAPlan(HttpServletRequest request) {
		return new ModelAndView("createAPlan", "plan", new Plan());

		
	}
	
	@RequestMapping(value = "/insurance/sanctionInsurance.htm", method = RequestMethod.GET)
	public ModelAndView sanctionInsurance(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView("sanctionAdminPanel");
		List<CaseSheet> caseSheets = new ArrayList<CaseSheet>();
		try
		{
			CaseSheetDAO caseSheetDAO = daoFactory.createCaseSheetDAO();
			caseSheets = caseSheetDAO.getCaseSheets();
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("type", "caseSheets");
			map.put("cases", caseSheets);
			modelAndView.addObject("map", map);
			return modelAndView;
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage()+"Error in Admin Controller - Sanction");
		}
		return modelAndView;
	
	}
	
	@RequestMapping(value = "/insurance/planCreate.htm", method = RequestMethod.POST)
	public String handleCreateForm(HttpServletRequest request, @ModelAttribute("plan") Plan plan, ModelMap map,BindingResult result) {
		
		RegisterPlanDAO registerPlanDAO = daoFactory.createPlanDAO();
		planCreateValidator.validate(plan, result);

		if (result.hasErrors()) {
			return "error-page";
		}
		try
		{
			System.out.print("Create a Plan");

			Plan u = registerPlanDAO.register(plan);
		}
		catch (PlanCreateExceptions e) {
			System.out.println(e.getMessage());
			return "error";
		}
		return "adminPanel";
		
		
	}

}
