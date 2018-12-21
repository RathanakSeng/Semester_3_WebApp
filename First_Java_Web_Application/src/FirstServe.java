import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class FirstServe extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doPost");
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("pass");

        if(request.getParameter("name").equalsIgnoreCase("rathanak"))
        {
            HttpSession sess = request.getSession();
            sess.setAttribute("name", name);
            RequestDispatcher rd = request.getRequestDispatcher("/SuccessServe");
            request.setAttribute("email", email);
            request.setAttribute("pass", password);
            rd.include(request,response);// This class not in
        }
        else
        {
            RequestDispatcher rd = request.getRequestDispatcher("/FailureServe");
            rd.include(request,response);// This class still in
        }
    }
}
