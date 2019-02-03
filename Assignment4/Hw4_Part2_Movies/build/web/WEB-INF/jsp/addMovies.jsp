<%-- 
    Document   : addMovies
    Created on : Feb 22, 2018, 8:02:40 AM
    Author     : Raghavi Kirouchenaradjou
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Movie</title>
    </head>
    <body>
         <form:form commandName="addMovie">
            Movie Title <form:input path="title"></form:input><p style="color:red"><form:errors path="title"></form:errors></p><br>
            Lead Actor <form:input path="actor"></form:input><p style="color:red"><form:errors path="actor"></form:errors></p><br>
            Lead Actress <form:input path="actress"></form:input><p style="color:red"><form:errors path="actress"></form:errors></p><br>
            Genre <form:input path="genre"></form:input><p style="color:red"><form:errors path="genre"></form:errors></p><br>
            Year <form:input path="year"></form:input><p style="color:red"><form:errors path="year"></form:errors></p><br>
             <input type="submit" value="Add Movie">
        </form:form>
    </body>
</html>
