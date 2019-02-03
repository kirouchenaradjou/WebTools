<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/WEB-INF/tlds/mytld.tld" prefix="m" %> 

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome to Spring Web MVC project</title>
    </head>

    <body>
          <c:if test="${(requestScope.map.type ne 'csvRead') && (requestScope.map.type ne 'insertData')}">

        <form id="myForm" action="csv.htm" method="post">
                Enter the file name : <input type="text" name="csvFileName"/>
                <br/><input type="submit" value="Submit"/>
        </form>
            </c:if>
          <c:if test="${(requestScope.map.type eq 'csvRead')}">
               <form id='form1' name='myForm2'  method="post"  action="csv.htm" >
            
                <m:hello fileName="${requestScope.map.fileName}"> </m:hello>
                
                <br/><input type="submit" value="Insert" name="action"/> </form>
          </c:if>
                 <c:if test="${(requestScope.map.type eq 'insertData')}">
                  <h3>${requestScope.map.count} records is been added to DataBase</h3>
            </c:if>
      
    </body>
</html>
