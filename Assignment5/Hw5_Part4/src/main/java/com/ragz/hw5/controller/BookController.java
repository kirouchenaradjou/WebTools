/**
 * 
 */
package com.ragz.hw5.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ragz.hw5.dao.BooksDAO;
import com.ragz.hw5.exceptions.BooksException;
import com.ragz.hw5.pojo.Books;

/**
 * @author Raghavi Kirouchenaradjou
 *
 */
@Controller
public class BookController {

	@Autowired
	@Qualifier("bookDAO")
	BooksDAO bookDAO;

	@RequestMapping(value = "/book/books.htm", method = RequestMethod.GET)
	public ModelAndView numBooks(HttpServletRequest request) {

		HttpSession session = request.getSession();
		String numBooks = request.getParameter("numBooks");
		session.setAttribute("numBooks", numBooks);
		return new ModelAndView("tableview");
	}

	@RequestMapping(value = "/book/book/addBooks.htm", method = RequestMethod.POST)
	public ModelAndView addBooks(HttpServletRequest request) throws Exception {
		HttpSession session = (HttpSession) request.getSession();
		String numBook = (String) session.getAttribute("numBooks");
		int numBooks = Integer.parseInt(numBook);
		int count = 0;

		Books book;
		try {
			for (int i = 1; i <= numBooks; i++) {

				String isbn = ((String) request.getParameter("isbn" + i));
				String title = ((String) request.getParameter("title" + i));
				String author = ((String) request.getParameter("authors" + i));
				float price = (Float.parseFloat(request.getParameter("price" + i)));

				book = new Books(isbn, title, author, price);
				if (bookDAO.addBooks(book)) {
					count++;
				}
			}
			if (count == numBooks) {
				return new ModelAndView("booksAddedSucces", "numBooksAdded", numBooks);
			}

		} catch (BooksException e) {
			System.out.println(e.getMessage());
			return new ModelAndView("error", "errorMessage", "error while adding books");
		}
		return null;
	}
}
