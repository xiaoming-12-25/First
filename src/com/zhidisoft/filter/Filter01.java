package com.zhidisoft.filter;

import com.zhidisoft.system.entity.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebFilter("/*")
public class Filter01 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        String uri = req.getRequestURI();
        if (uri.contains("/login") || uri.contains("/static")){
            filterChain.doFilter(req,resp);
            return;
        }
        if (uri.contains("/login.do")||uri.contains("/register.do")||uri.contains("/ver.do")) {
            filterChain.doFilter(req,resp);
            return;
        }
        User user = (User) req.getSession().getAttribute("user");
        if (user!=null){
            filterChain.doFilter(req,resp);
            return;
        }
        resp.sendRedirect("/login/login.jsp");
    }

    @Override
    public void destroy() {

    }
}
