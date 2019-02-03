package com.neu.servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        /**
         * Check if the cookie object is there if not , redirect to the login page
         * Now check login credentials if remember me is clicked store the cookie
         * else the cookie object is not set and would follow the same logic
         
         **/
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
                            
                    RequestDispatcher RequetsDispatcherObj = request.getRequestDispatcher("searchCourse.jsp");
                    RequetsDispatcherObj.forward(request, response);
                    break;
                }
               
            }
        } else {
            
            RequestDispatcher RequetsDispatcherObj = request.getRequestDispatcher("login.jsp");
            RequetsDispatcherObj.forward(request, response);
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
                    response.sendRedirect("searchCourse.jsp");
                } else {
                    response.sendRedirect("login.jsp");
                    //username/password not correct, send user to error-page or login page
                }
            } else if (action.equals("logout")) {
                //invalidate() removes all the objects from the session
                session.invalidate();
                
                response.sendRedirect("login.jsp");
            }

        }
        else
        {
            RequestDispatcher RequetsDispatcherObj = request.getRequestDispatcher("login.jsp");
            RequetsDispatcherObj.forward(request, response);
        }
        }
        
    }
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
