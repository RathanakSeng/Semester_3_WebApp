import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class FirstServlet extends javax.servlet.http.HttpServlet {
    static int countUser;
    static int activeUser;
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        Cookie cookie = new Cookie("username", request.getParameter("username"));
        response.addCookie(cookie);
        countUser++;
        HttpSession session = request.getSession();
        session.setAttribute("countUser", countUser);
        activeUser++;

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.print("<h1>" + countUser + " visited the page</h1>");
        out.print("<h1>" + activeUser + " active on the page</h1>");
        out.print("<a href='SecondServlet'>Second page</a>");

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }
}
