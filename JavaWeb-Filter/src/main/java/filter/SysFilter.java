package filter;

import util.Constant;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SysFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {}

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;

        if(req.getSession().getAttribute(Constant.USER_SESSION) == null){
            resp.sendRedirect("/JavaWeb-Filter/sys/error.jsp");
            System.out.println("进行了一次过滤。。。。。。。。。。。。。。。。。。。。。。。");
            filterChain.doFilter(servletRequest, servletResponse);
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }

    public void destroy() {}
}
