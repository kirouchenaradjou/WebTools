 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Course View</title>
    </head>
    <body>
         [<a href='items.htm?action=search'>Go to Search page</a>]
        [<a href="login.htm?action=logout">Logout</a>]
        <h3> My Cart </h3>
        <!--if there are no course in the set-->
        
        <c:forEach items="${requestScope.mycartmodel}" var="cart">         
            Name:  ${cart.name} - Price: ${cart.price} [<a href='items.htm?action=remove&itemName=${cart.name}'>Remove Item</a>]<br />
                
                   </c:forEach>
    </body>
</html>
