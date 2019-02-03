<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Course View</title>
    </head>
    <body>
        [<a href='searchCourse.jsp'>Go to Search page</a>] 
        [<a href="login.do?action=logout">Logout</a>]
        <h3> Courses Added:</h3>
        <!--if there are no course in the set-->
      
        <c:forEach items="${myCourseSet}" var="course">         
            CRN: ${course.crn} - Course Name: ${course.name} [<a href='course.do?action=remove&crn=${course.crn}'>Remove Course</a>]<br />
                
                   </c:forEach>
  
    </body>
</html>
