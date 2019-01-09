import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "LogoutServlet")
public class LogoutServlet extends HttpServlet {
    static int countUser;
    static int activeUser;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        FirstServlet.activeUser--;
        Cookie[] cookies = request.getCookies();

        HttpSession session = request.getSession();
        countUser = (Integer) session.getAttribute("countUser");

        for (Cookie cki: cookies) {
            cki.setMaxAge(0);
            cki.setValue("");
            response.addCookie(cki);
        }
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}
