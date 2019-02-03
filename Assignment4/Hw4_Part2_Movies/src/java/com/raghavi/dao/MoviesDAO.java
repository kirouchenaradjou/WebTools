/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.raghavi.dao;

import com.raghavi.pojo.Movie;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Raghavi Kirouchenaradjou
 */
public class MoviesDAO {

    private PreparedStatement preparedStmt;

    public boolean addMovies(Movie movie) {

        java.sql.Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/moviedb", "root", "root");
        } catch (ClassNotFoundException ex) {
            System.out.println("ClassNotFoundException" + ex.getMessage());
            return false;

        } catch (SQLException ex) {
            System.out.println("SQLException" + ex.getMessage());
            return false;

        }

        try {
            // the mysql insert statement
            String query = " insert into movies (title, actor, actress, genre, year)"
                    + " values (?, ?, ?, ?, ?)";

            // create the mysql insert preparedstatement
            preparedStmt = connection.prepareStatement(query);
            preparedStmt.setString(1, movie.getTitle());
            preparedStmt.setString(2, movie.getActor());
            preparedStmt.setString(3, movie.getActress());
            preparedStmt.setString(4, movie.getGenre());
            preparedStmt.setInt(5, movie.getYear());

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
    public ArrayList<Movie> getMovieDetailsByQuery(String action,String query) {
        java.sql.Connection connection = null;
        Statement stmt = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/moviedb", "root", "root");
            stmt = connection.createStatement();
        } catch (ClassNotFoundException ex) {
            System.out.println("ClassNotFoundException" + ex.getMessage());
        } catch (SQLException ex) {
            System.out.println("SQLException" + ex.getMessage());
        }

        String sqlQuery = "SELECT * FROM movies WHERE " +action +" ='" + query + "'";
        System.out.println(sqlQuery);
        ArrayList<Movie> movieList = new ArrayList<Movie>();
        try {
            ResultSet rs = stmt.executeQuery(sqlQuery);

            while (rs.next()) {
                Movie movie = new Movie();
                movie.setTitle(rs.getString("title"));
                movie.setActor(rs.getString("actor"));
                movie.setActress(rs.getString("actress"));
                movie.setGenre(rs.getString("genre"));
                movie.setYear(rs.getInt("year"));
                movieList.add(movie);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException ex) {
                System.out.println("SQLException" + ex.getMessage());
            }
        }

        return movieList;
    }

}
