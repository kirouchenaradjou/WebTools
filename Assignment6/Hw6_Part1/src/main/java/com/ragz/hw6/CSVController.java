/**
 * 
 */
package com.ragz.hw6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ragz.hw6.dao.CSVDAO;
import com.ragz.hw6.pojo.CSV;
import com.ragz.hw6.pojo.User;

/**
 * @author Raghavi Kirouchenaradjou
 *
 */
@Controller
public class CSVController {
	
    private static final String PATH_CSV = "C:\\webToolsLab\\assignment4\\";

    @Autowired
	@Qualifier("csvDAO")
	CSVDAO csvDAO;

	@RequestMapping(value = "/csv/csv.htm", method = RequestMethod.GET)
	public ModelAndView getTheData(HttpServletRequest request,@RequestParam(required = false) Integer page,@RequestParam(required = false) String csvFileName) {
		ModelAndView modelAndView = new ModelAndView("home");
         List<CSV> csvList = new ArrayList<CSV>();
         csvList = csvDAO.getCSVData("SalesOrder",PATH_CSV);
         Map<String, Object> map = new HashMap<String, Object>();
         map.put("csvList", csvList);
         map.put("type", "csvRead");
         PagedListHolder<CSV> pagedListHolder = new PagedListHolder<CSV>(csvList);
 		pagedListHolder.setPageSize(100);
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
 		modelAndView.addObject("map",map);
 		

         return modelAndView;
	}
	
	@RequestMapping(value = "/csv/csv/csv.htm", method = RequestMethod.POST)
	public ModelAndView saveToExcel(Integer page,@RequestParam(required = false) String csvFileName) {
		List<CSV> csvList = new ArrayList<CSV>();
        csvList = csvDAO.getCSVData("SalesOrder",PATH_CSV);
        
		return new ModelAndView("excelView","csvList",csvList);
}}
