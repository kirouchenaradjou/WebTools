<%-- 
    Document   : browseView
    Created on : Feb 25, 2018, 9:56:06 AM
    Author     : Raghavi Kirouchenaradjou
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Searched Data</title>
    </head>
    <body>
         You searched for ${requestScope.map.querySearched}
        <h2>Here are the searched results: </h2>
        
         <c:forEach items="${requestScope.map.movieList}" var="movie">    
             <strong>Movie Title : </strong>  ${movie.title}<br>
             <strong>Lead Actor : </strong>  ${movie.actor}<br>
             <strong>Lead Actress : </strong>  ${movie.actress}<br>
             <strong>Genre : </strong>  ${movie.genre}<br>
             <strong>Year : </strong>  ${movie.year}<br>
         </c:forEach>
    </body>
</html>
