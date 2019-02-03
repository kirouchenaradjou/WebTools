<%-- 
    Document   : booksAddedFailed
    Created on : Feb 25, 2018, 3:58:09 PM
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
 Only ${requestScope.message} books added successfully, remaining Failed<br><br><br>
        <a href="index.htm">Click here to go to the Homepage</a>    </body>
</html>
