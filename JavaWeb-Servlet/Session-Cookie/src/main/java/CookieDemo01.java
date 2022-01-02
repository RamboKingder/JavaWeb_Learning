import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Date;

public class CookieDemo01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 固定的：解决中文编码的问题
        req.setCharacterEncoding("GBK");
        resp.setCharacterEncoding("GBK");

        int continueTime = 8;
        PrintWriter out = resp.getWriter();
        Cookie[] cookies = req.getCookies();

        if(cookies!=null){
            boolean findFlag = false;
            for (Cookie cookie : cookies) {
                if(cookie.getName().equals("lastVisitTime")){
                    Long lastVisitTime = Long.parseLong(cookie.getValue());
                    Date date = new Date(lastVisitTime);
                    out.println("您上次访问的时间是：" + date.toLocaleString());
                    out.println("本站cookie的有效时间只有：" + continueTime + "秒");
                    findFlag = true;
                    break;
                }
            }
            if(!findFlag){
                out.println("这是您第一次访问本站！");
            }

        }
        else {
            out.println("这是您第一次访问本站！");
        }

        Cookie cookie = new Cookie("lastVisitTime", System.currentTimeMillis()+"");

        cookie.setMaxAge(continueTime);
        // 服务器给客户端响应一个Cookie
        resp.addCookie(cookie);


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
