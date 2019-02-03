<%@page import="java.util.concurrent.CountDownLatch"%>
<%@page import="bean.Items"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
    <head>
        <title>My Cart</title>
    </head>
    <body>
        <form method='post' action='items.do'>
            <h2> Results found </h2>
            <%
              ArrayList<Items> searchResults = ( ArrayList<Items>)request.getAttribute("searchResults");;
             
              for(Items item : searchResults)
              {
                  String itemName = item.getName();
                  String itemPrice = item.getPrice();
                 // String courseInst =  course.getInstructor();
                  out.println("<input type='checkbox' name = 'itemName' value='"+ itemName +"'/>" +itemName +  "("+ itemPrice + ")"+ "[<a href='items.do?action=add&itemName="+ itemName+"'>Add Item</a>]<br>");
              }
            %>
            <input type='hidden' name='action' value='add'/>
            <input type='submit' value='Add selected courses'>
        </form>
    </body>
</html>
