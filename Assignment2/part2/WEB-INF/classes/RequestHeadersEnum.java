import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.*;


public class RequestHeadersEnum extends HttpServlet {
  @Override
  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
      throws ServletException, IOException {
   response.setContentType("text/html");
    PrintWriter out = response.getWriter();
     String docType =
      "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 " +
      "Transitional//EN\">\n";
    String title = "Part 2: Assignment Request Headers via Enumeration";
     out.println(docType +
                "<HTML>\n" +
                "<HEAD><TITLE>" + title + "</TITLE></HEAD>\n" +
                "<BODY>\n" +
                "<TABLE BORDER=1 ALIGN=\"CENTER\" style='width:300px;'>\n" +
                "<TR>\n" +
                "<TH>Header Name</TH><TH>Header Value</TH>");
    Enumeration<String> headerNames = request.getHeaderNames();
    while(headerNames.hasMoreElements()) {
      String headerName = headerNames.nextElement();
      out.println("<TR><TD>" + headerName);
      out.println("    <TD>" + request.getHeader(headerName));
    }
    out.println("</TABLE>\n</BODY></HTML>");
  }

  
  
  @Override
  public void doPost(HttpServletRequest request,
                     HttpServletResponse response)
      throws ServletException, IOException {
    doGet(request, response);
  }
}
