package filter;

import javax.servlet.*;
import java.io.IOException;

public class CharacterEncodingFilter implements Filter{
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("Web服务器启动的时候CharsetEncodingFilter就会初始化");
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        servletResponse.setContentType("text/html;");
        servletRequest.setCharacterEncoding("UTF-8");
        servletResponse.setCharacterEncoding("UTF-8");

        System.out.println("CharsetEncodingFilter执行前...");
        // 让我们的请求继续走，如果不写，程序到这里就会拦截停止
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("CharsetEncodingFilter执行后...");

    }

    public void destroy() {
        System.out.println("Web服务器关闭的时候CharsetEncodingFilter会被销毁");
    }
}
