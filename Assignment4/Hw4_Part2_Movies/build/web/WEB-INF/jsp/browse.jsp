<%-- 
    Document   : browse
    Created on : Feb 22, 2018, 10:44:26 AM
    Author     : Raghavi Kirouchenaradjou
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Searching Movies Page</title>
    </head>
    <body>
        <h2>Searching Movies</h2>
          <form id="form" action="browse.htm" method="get" >
                
                <br />                 
                Keyword <input type="text" name="query"/> <br/><br/>
                <input type="radio" name="searchType" value="title" checked=""/> Search By Title
                <input type="radio" name="searchType" value="actor"/> Search By Actor
                <input type="radio" name="searchType" value="actress"/> Search By Actress
                <input type="hidden" name="action" value="search" />
                <br/><input type="submit" value="SEARCH MOVIES"/>
            </form>
    </body>
</html>
