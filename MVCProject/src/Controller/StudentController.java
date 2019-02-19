package Controller;

import model.Student;

import java.io.IOException;

public class StudentController extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        Student student = new Student();
        student.setId(request.getParameter("id"));
        student.setName(request.getParameter("name"));

        if (student.validate(student)) {
            request.getRequestDispatcher("success.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("err.jsp").forward(request, response);
        }
    }
}
