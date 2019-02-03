/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.raghavi.controller;

import com.raghavi.dao.MoviesDAO;
import com.raghavi.pojo.Movie;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 *
 * @author Raghavi Kirouchenaradjou
 */
public class BrowseController extends AbstractController {
    
    public BrowseController() {
    }
    
    protected ModelAndView handleRequestInternal(
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        String searchType = request.getParameter("searchType");
        String searchQuery = request.getParameter("query");
        ArrayList<Movie> movieList = new MoviesDAO().getMovieDetailsByQuery(searchType, searchQuery);
           Map<String, Object> map = new HashMap<String, Object>();
            map.put("movieList", movieList);
            map.put("querySearched", searchQuery);
        return new ModelAndView("browseView","map",map);
    }
    
}
