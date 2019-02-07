package com.filter;

import user.authentication.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.FileOutputStream;
import java.io.IOException;

@WebFilter(filterName = "LoginFilter")
public class LoginFilter implements Filter {
    FilterConfig filterConfig = null;
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        String name = req.getParameter("name");
        String remoteAddr = req.getRemoteAddr();
        String requestURI = ((HttpServletRequest) req).getRequestURI();
        String protocol = req.getProtocol();
        User user = new User();
        user.setName(name);
        user.setIpAddr(remoteAddr);
        user.setProtocol(protocol);
        user.setURI(requestURI);
        String filepath = filterConfig.getInitParameter("filePath");
        try (FileOutputStream file = new FileOutputStream(filepath, true)) {
            file.write(user.toString().getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {
        this.filterConfig = config;
    }

}
