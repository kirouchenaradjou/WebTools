/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *
 * @author Raghavi Kirouchenaradjou
 */
public class RetrieveData_ParamNames extends HttpServlet {
  protected void doPost(HttpServletRequest request,
            HttpServletResponse response) 
            throws ServletException, IOException {
      Enumeration paramNames = request.getParameterNames();

        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
 
        out.print("<html><body>");
        out.print("<h1> Your Details...</h1>");
        out.println("<table border=\"1\" cellpadding = \"5\"" + 
                " cellspacing = \"5\">");
        out.println("<tr> <th>Parameter Name</th>" + 
                "<th>Parameter Value</th></tr>");
         while(paramNames.hasMoreElements()) {
         String paramName = (String)paramNames.nextElement();
         out.print("<tr><td>" + paramName + "</td>\n<td>");
         String[] paramValues = request.getParameterValues(paramName);

         if (paramValues.length == 1) {
            String paramValue = paramValues[0];
            if (paramValue.length() == 0)
               out.println("<i>No Value</i>");
               else
               out.println(paramValue);
         } else {
            out.println("<ul>");

            for(int i = 0; i < paramValues.length; i++) {
               out.println("<li>" + paramValues[i]);
            }
            out.println("</ul>");
         }
      }
      out.println("</tr>\n</table>\n</body></html>");
   }
   
}  
