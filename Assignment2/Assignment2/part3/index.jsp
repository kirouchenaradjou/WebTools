<%-- 
    Document   : index
    Created on : Feb 4, 2018, 10:19:13 PM
    Author     : Raghavi Kirouchenaradjou
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ page import="java.util.*" %>
<%@ page import="java.io.*" %>
<%@ page import="javax.servlet.*" %>
<!DOCTYPE html>
<HTML>
<HEAD>
    <TITLE>Request header via Enumeration</TITLE>
</HEAD>
<BODY>
  
  <br>
    <TABLE style="background-color: #9e9e9e17;" border="1">
        <TR><TH>Header Name</TH><TH>Header Value</TH></TR>
	<%
	 /*This method returns an enumeration of all the header names this 
          request contains.*/	    
         java.util.Enumeration names = request.getHeaderNames();
         while (names.hasMoreElements()) {
	 String hname = (String)names.nextElement();
	%>
	<tr>
            
	    <th> <%= hname %> </th>
		<td><%= request.getHeader(hname) %></td>
	</tr>
   <%
        }
   %>
 </body> 
</html>