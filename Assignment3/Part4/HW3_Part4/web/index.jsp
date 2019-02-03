<%-- 
    Document   : index
    Created on : Feb 15, 2018, 3:36:04 PM
    Author     : Raghavi Kirouchenaradjou
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="x"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/sql" prefix = "sql"%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Part 4 - HW3</title>
    </head>
    <body>
        <strong>
            <c:out value="${'This JSP Page has 3 Tags used from Core TagLib'}"/></strong> <br> 
        <c:out value="${'Core - forEach'}"/>  
        <table border="1">
            <tr>
                <th>Name</th>
                <th>Id</th>
            </tr>
            <c:forEach items="${list_students}" var="current">
                <tr>
                    <td><c:out value="${current.name}" /></td>
                    <td><c:out value="${current.id}" /></td>
                </tr>
            </c:forEach>
        </table><br>
        <c:out value="${'Core - c:url'}"/>  
        <a href="<c:url value="${requestScope.url }"></c:url>">Facebook URL</a>
            <br><br>
            <strong>
            <c:out value="${'This JSP Page has 3 Tags used from Formatting TagLib'}"/>  </strong><br>
        <c:out value="${'Formatting - fmt:bundle,fmt:message '}"/>  
        <br>
        <fmt:bundle basename="com.test.prop.french">
            1. <fmt:message key="ONE"/><br/>
            2. <fmt:message key="TWO"/><br/>
            3. <fmt:message key="THREE"/><br/>
            4. <fmt:message key="FOUR"/><br/>
            5. <fmt:message key="FIVE"/><br/>
        </fmt:bundle>
        <br>
        <c:out value="${'Formatting - fmt:formatDate '}"/>  <br>

        <c:out value="Formatting Dates"/>
        <c:set var="Date" value="<%=new java.util.Date()%>" />  
        <p>  
            Formatted Time :  
            <fmt:formatDate type="time" value="${Date}" />  
        </p>  
        <p>  
            Formatted Date :  
            <fmt:formatDate type="date" value="${Date}" />  
        </p>  
        <p>  
            Formatted Date and Time :  
            <fmt:formatDate type="both" value="${Date}" />  
        </p>
        <br><br>
        <strong>
            <c:out value="${'This JSP Page has 3 Tags used from XML TagLib'}"/></strong> <br>
        <c:out value="${'XML - x:parse, x:forEach '}"/>  <br>
        <c:set var = "xmltext">
        <books>
            <book>
                <name>Padam History</name>
                <author>KAVI</author>
                <price>100</price>
            </book>

            <book>
                <name>Great Mistry</name>
                <author>NUHA</author>
                <price>2000</price>
            </book>
        </books>
    </c:set>
    <x:parse xml = "${xmltext}" var = "output"/>

    <ul class = "list">
        <x:forEach select = "$output/books/book/name" var = "item">
            <li>Book Name: <x:out select = "$item" /></li>
            </x:forEach>
    </ul>
    <c:out value="${'XML x:choose --> Check if the author is Kavi'}"/>  <br>
    <x:choose>
        <x:when select = "$output//book/author = 'KAVI'">
            Book is written by KAVI
        </x:when>

        <x:when select = "$output//book/author = 'NUHA'">
            Book is written by NUHA
        </x:when>

        <x:otherwise>
            Unknown author.
        </x:otherwise>
    </x:choose>
            <br><br>
            <strong>
                <c:out value="${'This JSP Page has 3 Tags used from JSTL Functions TagLib'}"/> </strong>
                <br>
        <c:out value="${'Functions - fn:toUpperCase, fn:substringBefore and fn:substringAfter '}"/>  
        <br>
    <table border="1">
        <th>Name In UpperCase</th>
        <th>First Name </th>
        <th>Last Name</th>
        <th>ID</th>
            <c:forEach items="${list_students}" var="current">
                <c:set var = "string1" value = "${current.name}"/>

            <tr>
                <td><c:out value="${fn:toUpperCase(string1)}" /></td>
                <td><c:out value="${fn:substringBefore(string1, ' ')}" /></td>
                <td><c:out value="${fn:substringAfter(string1, ' ')}" /></td>
                <td><c:out value="${current.id}" /></td>
            </tr>
        </c:forEach>
    </table>
    <%--
    <sql:setDataSource var = "snapshot" driver = "com.mysql.jdbc.Driver"
 url = "jdbc:mysql://localhost/DB"
 user = "raghavi"  password = "raghavi"/>
<sql:query dataSource = "${snapshot}" var = "result">
    SELECT * from Employees;
 </sql:query>
    <sql:update dataSource = "${snapshot}" var = "count">
 INSERT INTO Employees VALUES (104, 2, 'Ragavi', 'K');
</sql:update> 
    --%>
</body>
</html>
