<%-- 
    Document   : mainPage
    Created on : Feb 22, 2018, 8:55:40 AM
    Author     : Raghavi Kirouchenaradjou
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Movie Store</title>
    </head>
    <body>
        
        <h1>Welcome to our Movie Store</h1>
            Please make your selection below :
             <form action='main.htm' method="post" >
            <select name="movieStore" id="movieStore">
                <option value="browse">Browse Movies</option>
                <option value="add_movies">Add Movie to the Database</option>

            </select>
            <input type="submit" value="Send" />
        </form>
            <br>

    </body>
</html>
