<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Books Page</title>
</head>
<body>
<body>
        <form id="form" action="book/addBooks.htm" method="post" >

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