/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.raghavi.controller;

import com.raghavi.dao.BooksDAO;
import com.raghavi.pojo.Books;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 *
 * @author Raghavi Kirouchenaradjou
 */
public class AddBookController extends AbstractController {

    public AddBookController() {
    }

    protected ModelAndView handleRequestInternal(
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        HttpSession session = (HttpSession) request.getSession();
         String numBook = (String) session.getAttribute("numBooks");
            int numBooks = Integer.parseInt(numBook);
         BooksDAO booksDAO = (BooksDAO)this.getApplicationContext().getBean("booksDAO");//for Runtime injection
         int count =0;

        for (int i = 1; i <= numBooks; i++) {
                            Books book = new Books();

               book.setIsbn((String) request.getParameter("isbn" + i));
               book.setTitle((String) request.getParameter("title" + i));
               book.setAuthors((String) request.getParameter("authors" + i));
              book.setPrice(Float.parseFloat(request.getParameter("price" + i)));
        if(booksDAO.addBooks(book))
        {
            count++;
        }
        else
        {
            return new ModelAndView("booksAddedFailed","numBooksAdded",count);
        }
        }
        if(count==numBooks)
        {
            return new ModelAndView("booksAddedSucces","numBooksAdded",numBooks);
        }
        return null;
    }

}
