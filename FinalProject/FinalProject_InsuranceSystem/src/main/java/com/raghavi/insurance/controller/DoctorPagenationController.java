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
import org.springframework.beans.support.PagedListHolder;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.raghavi.insurance.dao.DAOFactory;
import com.raghavi.insurance.dao.DoctorDAO;
import com.raghavi.insurance.exceptions.DoctorException;
import com.raghavi.insurance.pojo.Doctor;

/**
 * @author Raghavi Kirouchenaradjou
 *
 */
@Controller
@RequestMapping("/insurance/*")
public class DoctorPagenationController {

	@Autowired
	DAOFactory daoFactory;

	@RequestMapping(value = "/insurance/getDoctorList.htm", method = RequestMethod.GET)
	public ModelAndView listOfUsers(@RequestParam(required = false) Integer page,
			@RequestParam(required = false) String specilaist,HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView("bookAnAppointmnent");
		List<Doctor> docorList = new ArrayList<Doctor>();

		DoctorDAO doctorDAO = daoFactory.createDoctorDAO();
		try {
			if(request.getParameter("specialistSelection")==null || request.getParameter("specialistSelection").equals("All"))
			{
				docorList = doctorDAO.getDoclist();
			}
			else
			{
			docorList = doctorDAO.getDoclist(request.getParameter("specialistSelection"));
			}
		} catch (DoctorException ex) {
			System.out.println("Exception while getting doc details" + ex);
		}

		PagedListHolder<Doctor> pagedListHolder = new PagedListHolder<Doctor>(docorList);
		pagedListHolder.setPageSize(2);
		modelAndView.addObject("maxPages", pagedListHolder.getPageCount());

		if (page == null || page < 1 || page > pagedListHolder.getPageCount())
			page = 1;

		modelAndView.addObject("page", page);
		if (page == null || page < 1 || page > pagedListHolder.getPageCount()) {
			pagedListHolder.setPage(0);
			modelAndView.addObject("users", pagedListHolder.getPageList());

		} else if (page <= pagedListHolder.getPageCount()) {
			pagedListHolder.setPage(page - 1);
			modelAndView.addObject("users", pagedListHolder.getPageList());
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("type", "getDoc");
		modelAndView.addObject("map", map);
		return modelAndView;
	}

	@RequestMapping(value = "/insurance/getDoctorList.htm", method = RequestMethod.POST)
	public ModelAndView bookAnAppointment(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView("bookAnAppointmnent");
		HttpSession session = request.getSession(false);
		String emailID = (String) session.getAttribute("username");
		int doctorID = Integer.parseInt(request.getParameter("docwho"));

		try {
			DoctorDAO doctorDAO = daoFactory.createDoctorDAO();
			doctorDAO.bookAnAppointment(doctorID,emailID);

		} catch (Exception e) {

		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("type", "bookNow");
		modelAndView.addObject("map", map);
		return modelAndView;
	}
}
