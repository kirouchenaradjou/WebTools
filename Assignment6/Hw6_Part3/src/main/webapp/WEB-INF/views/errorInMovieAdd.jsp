<%-- 
    Document   : error
    Created on : Feb 17, 2018, 10:33:49 AM
    Author     : Raghavi Kirouchenaradjou
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error in Login</title>
    </head>
    <body>
        <!-- Context Path is the entire : http://localhost:8080/Lab5 -->
        <c:set var="contextPath" value="${pageContext.request.contextPath}">  </c:set>
            
              <p>${requestScope.message}</p>
        <a href="${contextPath}">Click here to go back to the movie page</a>
    </body>
</html>
