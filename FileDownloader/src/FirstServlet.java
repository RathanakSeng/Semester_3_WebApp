import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "FirstServlet")
public class FirstServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter print = response.getWriter();
        String name = request.getParameter("name");
        print.println("<h1> Hello " + name + "</h1>");
        print.println("<br>");
        print.println("<form action='FileDownloadServlet' method='get'>" +
                "<select name='extension'>\n" +
                "  <option value='.txt'>Text file</option>\n" +
                "  <option value='.doc'>MsWord file</option>\n" +
                "  <option value='.pdf'>Pdf</option>\n" +
                "</select>" +
                "<input type='submit' value='download'/>" +
                "</form>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
