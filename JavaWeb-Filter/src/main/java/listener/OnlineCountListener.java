package listener;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class OnlineCountListener implements HttpSessionListener {
    // session创建监听器：一旦有session创建就会触发这个监听器
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println(se.getSession().getId());
        ServletContext servletContext = se.getSession().getServletContext();
        Integer onlineCount = (Integer) servletContext.getAttribute("OnlineCount");
        if(onlineCount == null){
            onlineCount = 1;
        }
        else {
            int count = onlineCount;
            onlineCount = count + 1;
        }

        servletContext.setAttribute("OnlineCount", onlineCount);
    }

    // session销毁监听器：一旦有session销毁就会出发这个监听器
    public void sessionDestroyed(HttpSessionEvent se) {
        ServletContext servletContext = se.getSession().getServletContext();
        Integer onlineCount = (Integer) servletContext.getAttribute("OnlineCount");
        if(onlineCount == null){
            onlineCount = 0;
        }
        else {
            int count = onlineCount;
            onlineCount = count - 1;
        }

        servletContext.setAttribute("OnlineCount", onlineCount);
    }
}
