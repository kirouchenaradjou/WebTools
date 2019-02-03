<%-- 
    Document   : addMovieSuccess
    Created on : Feb 22, 2018, 8:33:10 AM
    Author     : Raghavi Kirouchenaradjou
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         <c:set var="contextPath" value="${pageContext.request.contextPath}">  </c:set>
            
              <p>${requestScope.message}</p>
        <a href="${contextPath}/movie.htm">Click here to go back to the movie page</a>
    </body>
</html>
