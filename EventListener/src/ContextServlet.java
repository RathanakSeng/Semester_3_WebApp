import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ContextServlet")
public class ContextServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext sct = getServletContext();

        sct.setAttribute("name", "Nak");
        sct.setAttribute("name", "Rathanak");
        sct.removeAttribute("name");

        String name = (String)sct.getAttribute("name");
        String color = sct.getInitParameter("color");
    }
}
