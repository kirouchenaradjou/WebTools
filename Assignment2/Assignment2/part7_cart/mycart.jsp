<%@page import="java.util.HashSet"%>
<%@page import="bean.Items"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Course View</title>
    </head>
    <body>
        [<a href='search.jsp'>Go to Search page</a>] 
        [<a href="login.do?action=logout">Logout</a>]
        <h3> Courses Added:</h3>
        <!--if there are no course in the set-->
        <%
            HashSet<Items> myCart = (HashSet<Items>) session.getAttribute("myCart");
            if (myCart == null) {
                out.println("<div><p> No Course Added for you.</p></div>");
            } else {
                //else if there are courses, display every course in the set
                for (Items item : myCart) {
                    out.println("Name :  " + item.getName()+ " - Price: " + item.getPrice()+ "[<a href='items.do?action=remove&itemName=" + item.getName()+ "'>Remove Item</a>]<br />");
                }
            }
        %>
       
    </body>
</html>
