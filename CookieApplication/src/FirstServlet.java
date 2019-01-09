import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class FirstServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        /* Cookie ck = new Cookie("name", request.getParameter("name"));
        response.addCookie(ck); */

        String name = request.getParameter("name");
        /* HttpSession ss = request.getSession();
        ss.setAttribute("name", name); */

        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
//        out.println("<a href='SecondServlet'> hit me</a>");

//        out.println("<a href='SecondServlet?name="+name+"'> hit me</a>");

        /* out.println("<form action='SecondServlet' method='get'>" +
                "<input type='hidden' value="+name+" name='name'/>" +
                "<input type='submit' value='hit me'/>"); */
        RequestDispatcher rd = request.getRequestDispatcher("/SecondServlet");
        rd.forward(request, response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }
}
