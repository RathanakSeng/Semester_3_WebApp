import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class SuccessServe extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession sess = req.getSession();
        PrintWriter out = resp.getWriter();
        String name = (String)sess.getAttribute("name");
        resp.setContentType("text/html");
        out.print("<h3> Hello! " + name + "</h3>" + "<br><a href='LogoutServe'>Logout</a>");
    }
}
