/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 *
 * @author Raghavi Kirouchenaradjou
 */
public class LoginController extends AbstractController {
    
    public LoginController() {
    }
    
    protected ModelAndView handleRequestInternal(
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        String action = request.getParameter("action");

        Cookie cookie = null;
        Cookie[] cookies = null;
        boolean foundCookie = false;
        // Get an array of Cookies associated with this domain
        cookies = request.getCookies();
         
        if ((cookies != null)) {
                for (Cookie ck : cookies) {
                if (ck.getName().equals("username") ) {
                    if(action!=null && action.equals("logout"))
                    {
                        foundCookie = false;
                        break;
                    }
                            foundCookie = true;
                            
                                        return new ModelAndView("searchCourse");

                }
               
            }
        } else {
            
           return new ModelAndView("login");
        }
        if(!foundCookie)
        {
        HttpSession session = request.getSession(true);
        if (action != null) {
            if (action.equals("login")) {

                String username = request.getParameter("username");
                String password = request.getParameter("password");

                //Normally, we will need to connect to the DB to validate username/password
                //DB Connection will be discussed later
                //For now, we assume, username: admin, password: secret
                if (username.equals("admin") && password.equals("admin")) {
                    //username/password correct, go to search page
                    //add username to the session
                    session.setAttribute("username", username);
                    if (request.getParameter("rememberMe") != null) {
                        Cookie ck = new Cookie("username", username);
                        ck.setMaxAge(60 * 60 * 24);
                        response.addCookie(ck);
                    }
// response is an instance of type HttpServletReponse
                    return new ModelAndView("searchCourse");
                } else {
                    return new ModelAndView("login");
                    //username/password not correct, send user to error-page or login page
                }
            } else if (action.equals("logout")) {
                //invalidate() removes all the objects from the session
                session.invalidate();
                
                return new ModelAndView("login");
            }

        }
        else
        {
           return new ModelAndView("login");
        }
        }
        
    
        return new ModelAndView("login");
    }
}
    

