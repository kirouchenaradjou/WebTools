/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.raghavi.dao;

import com.raghavi.pojo.Books;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Raghavi Kirouchenaradjou
 */
public class BooksDAO {
 private PreparedStatement preparedStmt;

    public boolean addBooks(Books book) {

        java.sql.Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/booksdb", "root", "root");
        } catch (ClassNotFoundException ex) {
            System.out.println("ClassNotFoundException" + ex.getMessage());
            return false;

        } catch (SQLException ex) {
            System.out.println("SQLException" + ex.getMessage());
            return false;

        }

        try {
            // the mysql insert statement
            String query = " insert into books (isbn, title, authors, price)"
                    + " values (?, ?, ?, ?)";

            // create the mysql insert preparedstatement
            preparedStmt = connection.prepareStatement(query);
            preparedStmt.setString(1, book.getIsbn());
            preparedStmt.setString(2, book.getTitle());
            preparedStmt.setString(3, book.getAuthors());
            preparedStmt.setFloat(4, book.getPrice());

            // execute the preparedstatement
            int result = preparedStmt.executeUpdate();
            if (result>0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            System.out.println(ex);
            return false;

        } finally {
            try {
                if (preparedStmt != null) {
                    preparedStmt.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException ex) {
                System.out.println("SQLException" + ex.getMessage());
                return false;

            }
        }
        //return false;
    }
    
   
}
