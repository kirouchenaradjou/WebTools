/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bean.Items;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 *
 * @author Raghavi Kirouchenaradjou
 */
public class ItemsController extends AbstractController {

    List<Items> bookList;
    List<Items> musicList;
    List<Items> computerList;
    Set<Items> myCart = new HashSet<>();

    public ItemsController() {
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

    protected ModelAndView handleRequestInternal(
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        String action = request.getParameter("action");

        //this session will only be created when the user logs in. Otherwise do not create it.
        HttpSession session = request.getSession(false);
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

                return new ModelAndView("mycart","mycartmodel",myCart);

            }
            case "search": {
                if (request.getParameter("searchType") != null) {
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

                    } else if (searchType.equals("computer")) {
                        for (Items comItems : computerList) {
                            searchedResult.add(comItems);

                        }
                    }
                    return new ModelAndView("view", "viewmodel", searchedResult);
                } else {
                    return new ModelAndView("search");
                }

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
                return new ModelAndView("mycart", "mycartmodel", myCart);

            }
            case "redirect": {
                return new ModelAndView("mycart", "mycartmodel", myCart);
            }
            default:
                break;
        }
         return null;

    }

}
