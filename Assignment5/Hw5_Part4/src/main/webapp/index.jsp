<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome Page</title>
</head>
<body>
	<% if (request.isUserInRole("admin")) { %>
       <h1>How many books you want to have?</h1>
         <form id="form" action="book/books.htm" method="get" >
                
                <br />                 
                 <input type="text" name="numBooks"/> <br/><br/>
               
                <br/><input type="submit" value="Submit"/>
            </form>
      <% } %>
    </body>
</html>