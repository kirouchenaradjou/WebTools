/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
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
public class RetrieveData extends HttpServlet {
  protected void doPost(HttpServletRequest request,
            HttpServletResponse response) 
            throws ServletException, IOException {
        Map<String, String[]> map = request.getParameterMap();
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
 
        out.print("<html><body>");
        out.print("<h1> Your Details...</h1>");
        out.println("<table border=\"1\" cellpadding = \"5\"" + 
                " cellspacing = \"5\">");
        out.println("<tr> <th>Parameter Name</th>" + 
                "<th>Parameter Value</th></tr>");
        Set set = map.entrySet();
        Iterator it = set.iterator();
        while (it.hasNext()) {
            Map.Entry<String, String[]> entry = 
                (Entry<String, String[]>) it.next();
            String paramName = entry.getKey();
            out.print("<tr><td>" + paramName + "</td><td>");
            String[] paramValues = entry.getValue();
            if (paramValues.length == 1) {
                String paramValue = paramValues[0];
                if (paramValue.length() == 0)
                    out.println("<b>No Value</b>");
                else
                    out.println(paramValue);
            } else {
                out.println("<ul>");
                for (int i = 0; i < paramValues.length; i++) {
                    out.println("<li>" + paramValues[i] + "</li>");
                }
                out.println("</ul>");
            }
            out.print("</td></tr>");
        }
        out.println("</table></body></html>");
    }
}  
