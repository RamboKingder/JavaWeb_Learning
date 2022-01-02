import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class SessionDemo01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 解决中文乱码的问题，根据浏览器的不同而设置的
        req.setCharacterEncoding("GBK");
        resp.setCharacterEncoding("GBK");

        HttpSession session = req.getSession();
        session.setAttribute("person", new Person("龙潇岚", 20));
        String sessionId = session.getId();

        if(session.isNew()){
            resp.getWriter().write("Session创建成功，ID为：" + sessionId);
        }
        else {
            resp.getWriter().write("服务器中已经存在了Session，ID为：" + sessionId);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
