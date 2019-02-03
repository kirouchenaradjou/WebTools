<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Error in Login</title>
    </head>
    <body>
        <!-- Context Path is the entire : http://localhost:8080/Lab5 -->
        <c:set var="contextPath" value="${pageContext.request.contextPath}">  </c:set>
            
              <p>${requestScope.errorMessage}</p>
        <a href="${contextPath}">Click here to go back to the movie page</a>
    </body>
</html>