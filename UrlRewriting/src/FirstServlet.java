import javax.servlet.ServletConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "FirstServlet")
public class FirstServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        response.setContentType("text/html");
        String name = request.getParameter("name");
        PrintWriter out = response.getWriter();

        // Pass parameter from a page to other using hyper link || UrlRewriting
        // out.println("<a href='SecondServlet?name="+name+"'>click me</a>");

        ServletConfig con = getServletConfig();
        String color = con.getInitParameter("color");
        // hidden from filed
        out.println("<h1>" + color + "</h1>" +
                "<form action='SecondServlet' method='GET'>" +
                "<input type='hidden' name='name' value='"+request.getParameter("name")+"'/>" +
                "<input type='submit' value='second'/>" +
                "</form>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }
}
