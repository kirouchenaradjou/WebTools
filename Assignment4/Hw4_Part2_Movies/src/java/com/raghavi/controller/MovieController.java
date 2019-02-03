/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.raghavi.controller;

import com.raghavi.dao.MoviesDAO;
import com.raghavi.pojo.Movie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

/**
 *
 * @author Raghavi Kirouchenaradjou
 */
public class MovieController extends SimpleFormController {
    
    public MovieController() {
        //Initialize controller properties here or 
        //in the Web Application Context

        setCommandClass(Movie.class);
        setCommandName("addMovie");
        setSuccessView("addMovieSuccess");
        setFormView("addMovies");
    }
    
//    @Override
//    protected void doSubmitAction(Object command) throws Exception {
//        throw new UnsupportedOperationException("Not yet implemented");
//    }

    //Use onSubmit instead of doSubmitAction 
    //when you need access to the Request, Response, or BindException objects
    
    @Override
    protected ModelAndView onSubmit(
            HttpServletRequest request, 
            HttpServletResponse response, 
            Object command, 
            BindException errors) throws Exception {
       ModelAndView mv = null;
        Movie movie = (Movie) command; // typecast to command
        request.getRequestURI();
        MoviesDAO moviesDAO = (MoviesDAO)this.getApplicationContext().getBean("moviesDAO");//for Runtime injection
        if(moviesDAO.addMovies(movie))
        {
            mv = new ModelAndView(getSuccessView(),"message","Movie Added Successfully");
        }
        else
        {
            mv = new ModelAndView("errorInMovieAdd","message","Movie to be added FAILED!!! ");
        }
        return mv;
    }
     
}
