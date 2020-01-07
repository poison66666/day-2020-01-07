package v2.servlet;

import v2.Request;
import v2.Response;
import v2.SessionServer;
import v2.business.User;

import java.io.IOException;

public class HelloServlet extends HttpServlet {
    @Override
    public void doGet(Request req, Response resp) throws IOException {
        String sessionId = null;
        String cookie = req.headers.get("Cookie");
        if (cookie != null) {
            // "username=陈沛鑫"
            sessionId = cookie.split("=")[1];
        }

        User user = SessionServer.get(sessionId);

        resp.setHeader("Content-Type", "text/plain; charset=UTF-8");
        resp.println("当前用户是 " + user.username);
        resp.println("账户余额是 " + user.balance);
    }
}
