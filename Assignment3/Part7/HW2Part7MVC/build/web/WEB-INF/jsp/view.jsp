 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <title>My Cart</title>
    </head>
    <body>
        <form method='post' action='items.htm'>
            <h2> Results found </h2>
           
             <c:forEach items="${requestScope.viewmodel}" var="item">         
            
                
                <input type='checkbox' name = 'itemName' value='${item.name}'/>${item.name} (${item.price}) [<a href='items.htm?action=add&itemName=${item.name}'>Add Item</a>]<br>
                   </c:forEach>
            <input type='hidden' name='action' value='add'/>
            <input type='submit' value='Add selected courses'>
        </form>
    </body>
</html>
