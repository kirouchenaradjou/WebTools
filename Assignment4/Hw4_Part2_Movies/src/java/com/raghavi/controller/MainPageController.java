/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.raghavi.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 *
 * @author Raghavi Kirouchenaradjou
 */
public class MainPageController extends AbstractController {
    
    public MainPageController() {
    }
    
    protected ModelAndView handleRequestInternal(
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
         String action = request.getParameter("movieStore");
         if(action!=null)
         {
           switch (action) {
            case "browse": {
                return new ModelAndView("browse");
            }
            case "add_movies" :
            {
                //this bypasses the view resolver, hence we write redirect
                return new ModelAndView("redirect:/addmovie.htm");
            }
              default:
                break;
                
    }
         }
         else
         {
              return new ModelAndView("mainPage");
         }
        return null;   
    }
}
