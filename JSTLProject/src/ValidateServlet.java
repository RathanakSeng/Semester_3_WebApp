import com.bean.Student;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class ValidateServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<Student> list = new ArrayList<Student>();

        list.add(new Student(1111, "Rathanak"));
        list.add(new Student(1112, "Vudthi"));
        list.add(new Student(1113, "ChunE"));
        list.add(new Student(1114, "MoonLight"));
        list.add(new Student(1115, "Luhen"));

        req.setAttribute("students", list);

        req.getRequestDispatcher("success.jsp").forward(req, resp);

    }
}
