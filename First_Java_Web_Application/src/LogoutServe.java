import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LogoutServe extends HttpServlet
{
    public void logOut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        HttpSession hs = req.getSession();
        hs.invalidate();
        req.getRequestDispatcher("index.jsp").forward(req, resp);

    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        logOut(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logOut(req, resp);
    }
}
