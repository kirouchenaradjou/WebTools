<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Movie Store</title>
    </head>
    <body>
        
        <h1>Welcome to our Movie Store</h1>
            Please make your selection below :
             <form action='movie/mainPage' method="post" >
            <select name="movieStore" id="movieStore">
                <option value="browse">Browse Movies</option>
                <option value="addmovies">Add Movie to the Database</option>

            </select>
            <input type="submit" value="Send" />
        </form>
            <br>

    </body>
</html>