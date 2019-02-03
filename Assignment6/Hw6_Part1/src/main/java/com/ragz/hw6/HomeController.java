package com.ragz.hw6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ragz.hw6.pojo.User;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView listOfUsers(@RequestParam(required = false) Integer page) {
		ModelAndView modelAndView = new ModelAndView("home");
		List<User> users = new ArrayList<User>();

		for (int i = 0; i < 100; i++) {
			User c = new User();
			c.setId(i);
			c.setName("name" + i);
			users.add(c);
		}

		PagedListHolder<User> pagedListHolder = new PagedListHolder<User>(users);
		pagedListHolder.setPageSize(20);
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
		// modelAndView.addObject("userList",users);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("type", "csvRead");
		modelAndView.addObject("map", map);
		return modelAndView;
	}

}
