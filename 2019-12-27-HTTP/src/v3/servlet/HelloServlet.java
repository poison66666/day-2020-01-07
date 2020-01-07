package v3.servlet;

import v3.Request;
import v3.Response;
import v3.SessionServer;
import v3.business.User;

import java.io.IOException;

public class HelloServlet extends HttpServlet{

    @Override
    public void doGet(Request req, Response resp) throws IOException {
        String sessionId = null;
        String cookie = req.headers.get("Cookie");
        if(cookie != null){
            sessionId = cookie.split("=")[1];
        }

        User user = SessionServer.get(sessionId);

        resp.setHeader("Content-Type","text/plain; charset=UTF-8");
        resp.println("当前用户是 "+user.username);
        resp.println("账户余额是 "+user.balance);
    }
}
