import javax.servlet.http.HttpSession;
import java.io.IOException;

public class FirstServe extends javax.servlet.http.HttpServlet {
    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
//        request.setAttribute("name", "Nak");
//        request.setAttribute("name", "Rathanak");
//        request.removeAttribute("name");
        HttpSession ss = request.getSession();

        try {
            Thread.sleep(300);
        } catch (InterruptedException r) {
            r.printStackTrace();
        }

        ss.invalidate();
    }
}
