import javax.servlet.Filter;
import java.io.IOException;
import java.io.PrintWriter;

public class MyFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(javax.servlet.ServletRequest req, javax.servlet.ServletResponse resp, javax.servlet.FilterChain chain) throws javax.servlet.ServletException, IOException {
        PrintWriter out = resp.getWriter();

        String name = req.getParameter("name");

        if (!name.equalsIgnoreCase("Rathanak")) {
            out.println("Wrong Input");
            return;
        }
        chain.doFilter(req, resp);

        out.println("Filter is invoked after!...");
    }

    public void init(javax.servlet.FilterConfig config) throws javax.servlet.ServletException {

    }

}
