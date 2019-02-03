/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Raghavi Kirouchenaradjou
 */
public class Part4_HW3 extends HttpServlet{
    //Global object belongs to every users.
    //Be careful, do not put anything here that you don't want to share.
    //Later this will come from the database.
          ArrayList list = new ArrayList();

    @Override
    public void init() {
        //This method will only be call for once
  Map author1 = new HashMap();
  author1.put("name", "Raghavi Kirouchenaradjou");
  author1.put("id", new Integer(1));
  list.add(author1);
  Map author2 = new HashMap();
  author2.put("name", "Deivakumaran Dhanasegaran");
  author2.put("id", new Integer(2));
  list.add(author2);
  Map author3 = new HashMap();
  author3.put("name", "Nithin Dhasa");
  author3.put("id", new Integer(3));
  list.add(author3);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         /*HttpSession session = request.getSession(true);
        session.setAttribute("list_students", list);*/
         request.setAttribute("list_students", list);
        request.setAttribute("url", "https://www.journaldev.com");
        RequestDispatcher RequetsDispatcherObj = request.getRequestDispatcher("index.jsp");
        RequetsDispatcherObj.forward(request, response);
    }
   

}
