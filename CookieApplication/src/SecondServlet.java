import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "SecondServlet")
public class SecondServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        out.println(request.getParameter("name"));

        ServletConfig cf = getServletConfig();
        String color = cf.getInitParameter("Color");
        out.println(color);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        /* Cookie[] ck = request.getCookies(); //Ck is store as Map
        for (Cookie mck : ck) {
            out.println(mck.getName() + " : " + mck.getValue());
        } */

        /* HttpSession ss = request.getSession();
        String name = (String) ss.getAttribute("name");
        out.println(name); */
        out.println(request.getParameter("name"));
    }
}
