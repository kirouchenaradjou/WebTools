<%-- 
    Document   : booksAddedSucces
    Created on : Feb 25, 2018, 3:54:50 PM
    Author     : Raghavi Kirouchenaradjou
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
           ${requestScope.numBooksAdded} books added successfully<br><br><br>
        <a href="${contextPath}/hw5/">Click here to go to the Homepage</a>
    </body>
</html>
