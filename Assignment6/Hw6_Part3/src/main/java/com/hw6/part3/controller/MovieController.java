/**
 * 
 */
package com.hw6.part3.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.hw6.part3.dao.MoviesDAO;
import com.hw6.part3.exceptions1.MoviesException;
import com.hw6.part3.pojo.Movie;

/**
 * @author Raghavi Kirouchenaradjou
 *
 */
@Controller
public class MovieController {

	@Autowired
	@Qualifier("movieDAO")
	MoviesDAO movieDAO;

	@RequestMapping(value = "/movie/mainPage", method = RequestMethod.POST)
	public ModelAndView selectMovie(HttpServletRequest request) {

		String action = request.getParameter("movieStore");

		if (action.equals("browse")) {
			return new ModelAndView("browse");
		} else if (action.equals("addmovies")) {

			return new ModelAndView("addMovies");
		}

		return new ModelAndView();
	}

	@RequestMapping(value = "/movie/movie/addMovie.htm", method = RequestMethod.POST)
	public ModelAndView addMovie(HttpServletRequest request) throws Exception {
		try {

			String title = request.getParameter("title");
			String actor = request.getParameter("actor");
			String actress = request.getParameter("actress");
			String genre = request.getParameter("genre");
			String year_string = request.getParameter("year");
			int year = Integer.parseInt(year_string);

			Movie movie_data = new Movie(title, actor, actress, genre, year);
			// MoviesDAO moviesDAO = new MoviesDAO();
			Movie movie = movieDAO.addMovies(movie_data);
			return new ModelAndView("addMovieSuccess", "movie", movie);

		} catch (MoviesException e) {
			System.out.println(e.getMessage());
			return new ModelAndView("error", "errorMessage", "error while adding movies");
		}

	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/movie/movie/browse.htm", method = RequestMethod.GET)
	public ModelAndView searchMovie(HttpServletRequest request) {
		List<Movie> movieList = new ArrayList<Movie>();
		try {
			String searchType = request.getParameter("searchType");
			String searchQuery = request.getParameter("query");
			movieList = movieDAO.getMovieDetailsByQuery(searchType, searchQuery);
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("movieList", movieList);
			map.put("querySearched", searchQuery);
			return new ModelAndView("browseView", "map", map);

		} catch (MoviesException e) {
			System.out.println(e.getMessage());
			return new ModelAndView("errorBrowseView", "errorMessage", "error while searching for movies");
		}

	}

}
