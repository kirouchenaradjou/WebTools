/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ragz.hw5.dao;


import org.hibernate.HibernateException;

import com.ragz.hw5.exceptions.BooksException;
import com.ragz.hw5.pojo.Books;

/**
 *
 * @author Raghavi Kirouchenaradjou
 */
public class BooksDAO extends DAO{
 
	public boolean addBooks(Books book) throws BooksException

	{
		try
		{
			begin();
			getSession().save(book);
			commit();
			return true;
			
		}
		catch (HibernateException e) {
            rollback();
            throw new BooksException("Exception while adding books : " + e.getMessage());
        }

	}
}
