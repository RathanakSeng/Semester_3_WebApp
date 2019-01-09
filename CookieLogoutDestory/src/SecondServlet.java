import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "SecondServlet")
public class SecondServlet extends HttpServlet {
    static int countUser;
    static int activeUser;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Cookie[] cookie = request.getCookies();

        HttpSession session = request.getSession();
        countUser = (Integer) session.getAttribute("countUser");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        for (Cookie cki: cookie) {
            out.print("<h1>" + cki.getName() + " : " + cki.getValue() + "</h1>");
        }
        out.print("<a href='LogoutServlet'>Logout</a>");
    }
}
