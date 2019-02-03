<!DOCTYPE html>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true" %>
<html>
    <head>
        <title>Select Courses</title>

        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="Cache-Control" content="no-cache, no-store, must-revalidate" />
        <meta http-equiv="Pragma" content="no-cache" />
        <meta http-equiv="Expires" content="0" />
        <!--This is html4 to disable cache-->
        <!--add those line later-->
    </head>
    <body>
        <div>
            <h2> Search Courses</h2>
            <form id="form" action="items.do" method="get" >
                <a href="login.do?action=logout">Logout</a>&nbsp;&nbsp;
                <a href="mycart.jsp">My Cart</a>
                <br />
                <br />                 
                Shop by the following <br/><br/>
                <input type="radio" name="searchType" value="books" checked=""/> Search By Books
                <input type="radio" name="searchType" value="music"/> Search By Music
                <input type="radio" name="searchType" value="computer"/> Search By Computer
                <input type="hidden" name="action" value="search" />
                <br/><input type="submit" value="SEARCH"/>
            </form>
        </div>
    </body>
</html>
