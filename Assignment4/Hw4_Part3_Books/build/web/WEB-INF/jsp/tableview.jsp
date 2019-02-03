<%-- 
    Document   : tableview
    Created on : Feb 25, 2018, 2:36:25 PM
    Author     : Raghavi Kirouchenaradjou
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Step 2</title>
    </head>
    <body>
        <form id="form" action="addBooks.htm" method="post" >

            <table border="1">
                <thead>
                    <tr>
                        <th>ISBN</th>
                        <th>Book Title</th>
                        <th>Authors</th>
                        <th>Price</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="num" begin="1" end="${sessionScope.numBooks}" step="1">
                        <tr>
                            <td><input style="width:100%"  type="text" name="isbn${num}" /></td>
                            <td><input style="width:100%"  type="text" name="title${num}" /></td>
                            <td><input style="width:100%"  type="text" name="authors${num}" /></td>
                            <td><input style="width:100%"  type="number" name="price${num}" /></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>

            <br/><input type="submit" value="Submit"/>
        </form>
    </body>
</html>
