/**
 * 
 */
package com.ragz.hw5.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.ragz.hw5.exceptions.MoviesException;
import com.ragz.hw5.pojo.Movie;

/**
 * @author Raghavi Kirouchenaradjou
 *
 */
public class MoviesDAO extends DAO {

	public Movie addMovies(Movie movie) throws MoviesException

	{
		try
		{
			begin();
			getSession().save(movie);
			commit();
			return movie;
			
		}
		catch (HibernateException e) {
            rollback();
            throw new MoviesException("Exception while adding movies : " + e.getMessage());
        }

	}
	
	 public List getMovieDetailsByQuery(String action,String query) throws MoviesException {
	        try {
	            begin();
	            Query q = getSession().createQuery("from Movie where "+action+" like :query");
	            //q.setString("action",action);
	            q.setString("query",'%'+query+'%');
	            List list = q.list();
	            commit();
	            return list;
	        } catch (HibernateException e) {
	            rollback();
	            throw new MoviesException("Could not list the movies ", e);
	        }
	    }
}
