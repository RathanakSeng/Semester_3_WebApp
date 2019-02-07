import javax.servlet.Filter;
import javax.servlet.http.HttpServletRequest;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class MyFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(javax.servlet.ServletRequest req, javax.servlet.ServletResponse resp, javax.servlet.FilterChain chain) throws javax.servlet.ServletException, IOException {
        PrintWriter out = resp.getWriter();
        out.println("Filter is invoked Before!...");

//        BufferedWriter bw = new BufferedWriter(new FileWriter("log.txt", true));
        String remoteAddr = req.getRemoteAddr();
        String requestURI = ((HttpServletRequest) req).getRequestURI();
        String protocol = req.getProtocol();
        System.out.println(remoteAddr + " : " + requestURI + " : " + protocol);

//        bw.write(remoteAddr + " : " + requestURI + " : " + protocol);

        chain.doFilter(req, resp);

        out.println("Filter is invoked After!...");
    }

    public void init(javax.servlet.FilterConfig config) throws javax.servlet.ServletException {

    }

}
