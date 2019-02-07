import com.demodao.DAO;
import com.demodao.StudentDao;
import com.model.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;

public class MyServlet extends HttpServlet {

    private static StudentDao studentDao;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        studentDao = new StudentDao();
        Student student_1 = getStudent(1);

        PrintWriter out = response.getWriter();
        out.println(student_1);
    }

    private Student getStudent(int id) {


        Student student = studentDao.findById(id);

        if (student != null) return student;
        return new Student("no-name-found", "no-dept-name-found", 00.0);
    }
}
