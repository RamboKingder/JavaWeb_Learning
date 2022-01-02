import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class SessionDemo02 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 解决中文乱码的问题，根据浏览器的不同而设置的
        req.setCharacterEncoding("GBK");
        resp.setCharacterEncoding("GBK");

        // 得到session
        HttpSession session = req.getSession();
        Person person = (Person) session.getAttribute("person");
        System.out.println(person.toString());

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
