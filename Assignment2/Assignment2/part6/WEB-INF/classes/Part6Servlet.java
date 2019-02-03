import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Part6Servlet extends HttpServlet {
    //Service method
    public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
    {
		PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Page 1 - Part6Servlet</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h2>Page 1</h2>");
        out.println("<form action = 'part6servlet' method = 'post'>");
        out.println("<p>Question 1: How many children do you have? </p>"
                + "<input type='number' name='ans' value='post' /><br />");
        out.println("<input type='hidden' name='page'  value='p1'/>");
        out.println("<input type =  'submit' value = 'Submit Query' name = 'button'/><br /></p>");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");
    }
    //Service method
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String page = request.getParameter("page");
        //create the Session object
        HttpSession session = request.getSession();

        if(page.equals("p1"))
        {
        //Store the answer
        Integer numOfChildren = Integer.parseInt(request.getParameter("ans"));
       //out.println("<html><head><script>function myFunction(id){");
//out.println("var ch = document.createElement('div');");
//out.println("for (i = 0; i < 3; i++) {");
//out.println("createTextbox.innerHTML = 'Test'");
//out.println("}}</script></head>");
        //out.println("<body onload=\"myFunction('"+ numOfChildren + "');>");
        out.println("<body>");
        out.println("<h2>Page 2</h2>");
        out.println("<form action = 'part6servlet' method = 'post'>");
        for(int i=1;i<=numOfChildren;i++)
        {
        	out.println("<p>Please enter the name of child number '"+ i + "' </p>");
        	out.println("<input type='text' name='child"+ i + "' /><br>");
        }
        out.println("<input type='hidden' name='page'  value='p2'/>");
        out.println("<input type='hidden' name='numOfChildren'  value='"+ numOfChildren + "'/>");
        out.println("<input type = 'submit' value = 'Submit Query' name = 'button'/><br /></p>");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");
        }
        else if(page.equals("p2"))
        {
       Integer numOfChildren = Integer.parseInt(request.getParameter("numOfChildren"));
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Part 6 </title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h2>Your children names are :</h2>");
        out.println("<ul>");
        


        for(int i=1;i<=numOfChildren;i++)
        {
        	 out.println("<li>"+ request.getParameter("child"+i)+"</li>");
        }
       out.println("</ul>");
        out.println("</body>");
        out.println("</html>");

        }
        
    
}
}
