package controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import model.utente.Utente;

import java.io.IOException;

@WebFilter(filterName = "/AccessControlFilter", urlPatterns = "/*")
public class AccessControlFilter extends HttpFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        Integer user = (Integer) req.getSession().getAttribute("user");
        Boolean admin = (Boolean) req.getSession().getAttribute("admin");

        String path = req.getServletPath();

        if(path.contains("/user/") && user == null) {

            res.sendRedirect(req.getContextPath() + "/auth/LoginServlet");
            return;
        }

        if(path.contains("/auth/") && user != null){

            res.sendRedirect(req.getContextPath() + "/common/StartServlet");
            return;
        }

        if(path.contains("/admin/") && admin == null){

            res.sendRedirect(req.getContextPath() + "/common/StartServlet");
            return;
        }

        chain.doFilter(req, res);
    }
}