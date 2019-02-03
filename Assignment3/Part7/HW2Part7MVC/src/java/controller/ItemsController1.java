package controller;

import bean.Items;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ItemsController1 extends HttpServlet {

    List<Items> bookList;
    List<Items> musicList;
    List<Items> computerList;
    //Global object belongs to every users.
    //Be careful, do not put anything here that you don't want to share.
    //Later this will come from the database.

    @Override
    public void init() {
        //This method will only be call for once
        bookList = new ArrayList<>();
        Items i1 = new Items();
        i1.setName("java programming");
        i1.setPrice("$123");

        Items i2 = new Items();
        i2.setName("Course fro learning web technologies used in frint end");
        i2.setPrice("$123");

        Items i3 = new Items();
        i3.setName("course for learning algorithms");
        ;
        i3.setPrice("$123");

        bookList.add(i1);
        bookList.add(i2);
        bookList.add(i3);

        musicList = new ArrayList<>();
        Items m1 = new Items();
        m1.setName("Waka Waka");
        m1.setPrice("$100");
        Items m2 = new Items();
        m2.setPrice("$40");
        m2.setName("Titanic");
        Items m3 = new Items();
        m3.setName("Show me the meaning");
        m3.setPrice("$50");

        musicList.add(m1);
        musicList.add(m2);
        musicList.add(m3);

        computerList = new ArrayList<>();
        Items c1 = new Items();
        c1.setName("Apple Mac Book");
        c1.setPrice("$40");
        Items c2 = new Items();
        c2.setPrice("$78");
        c2.setName("Windows 10");
        Items c3 = new Items();
        c3.setName("Windows 8");
        c3.setPrice("$100");

        computerList.add(c1);
        computerList.add(c2);
        computerList.add(c3);
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //We are using one servlet for multiple things.
        //action is the url parameter to differentiate between different requests
        String action = request.getParameter("action");

        //this session will only be created when the user logs in. Otherwise do not create it.
        HttpSession session = request.getSession(false);
        Set<Items> myCart;
        if (null != session.getAttribute("myCart")) {
            myCart = (Set<Items>) session.getAttribute("myCart");
        } else {
            myCart = new HashSet<>();
        }
        switch (action) {
            case "add": {
                String[] itemNames = request.getParameterValues("itemName");
                for (String itemName : itemNames) {
                    for (Items books : bookList) {
                        if (books.getName().equals(itemName)) {
                            myCart.add(books);
                        }
                    }
                    for (Items musItems : musicList) {
                        if (musItems.getName().equals(itemName)) {
                            myCart.add(musItems);
                        }
                    }
                    for (Items computer : computerList) {
                        if (computer.getName().equals(itemName)) {
                            myCart.add(computer);
                        }
                    }
                }
                session.setAttribute("myCart", myCart);
                RequestDispatcher rd = request.getRequestDispatcher("/mycart.jsp");
                rd.forward(request, response);
                break;
            }
            case "search": {
                String searchType = request.getParameter("searchType");
                ArrayList<Items> searchedResult = new ArrayList<>();
                if (searchType.equals("books")) {
                    for (Items book : bookList) {

                        searchedResult.add(book);
                    }

                } else if (searchType.equals("music")) {
                    for (Items music : musicList) {
                        searchedResult.add(music);

                    }
                    
                }
                else if (searchType.equals("computer")) {
                    for (Items comItems : computerList) {
                        searchedResult.add(comItems);

                    }
                }
                request.setAttribute("searchResults", searchedResult);
                RequestDispatcher rd = request.getRequestDispatcher("/view.jsp");
                rd.forward(request, response);
                break;
            }
            case "remove": {
                //To be completed by students as part of Lab HW
                //getParam for getting value from HTML page and getAttribute is for getting value from the previous JSP page
                String[] items = request.getParameterValues("itemName");
                for (String itemName : items) {
                    for (Items book : bookList) {
                        if (book.getName().equals(itemName)) {
                            myCart.remove(book);
                        }
                    }
                     for (Items music : musicList) {
                        if (music.getName().equals(itemName)) {
                            myCart.remove(music);
                        }
                    }
                      for (Items comp : computerList) {
                        if (comp.getName().equals(itemName)) {
                            myCart.remove(comp);
                        }
                    }
                }
                session.setAttribute("myCart", myCart);
                RequestDispatcher rd = request.getRequestDispatcher("/mycart.jsp");
                rd.forward(request, response);
                break;
            }
            default:
                break;
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
