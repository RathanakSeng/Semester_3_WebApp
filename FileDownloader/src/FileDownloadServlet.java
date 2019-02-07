import java.io.*;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FileDownloadServlet extends HttpServlet {
    public void init() throws ServletException
    {
        System.out.println("-----------------------------------------");
        System.out.println(" Init method is called in "
                + this.getClass().getName());
        System.out.println("--------------------------------------");
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String extension = req.getParameter("extension");
        String filename = getServletConfig().getInitParameter("FileName");
        String filepath = getServletConfig().getInitParameter("FilePath");
        resp.setContentType("text/plain");
        resp.setHeader("Content-disposition", "attachment; filename=" + filename + extension);
        try (FileInputStream file = new FileInputStream(filepath);
             ServletOutputStream out = resp.getOutputStream()) {
            int c;
            while ((c = file.read()) != -1) {
                out.write(c);
            }
            out.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void destroy()
    {
        System.out.println("-----------------------------------------");
        System.out.println(" destroy method is called in "
                + this.getClass().getName());
        System.out.println("-----------------------------------------");
    }
}
