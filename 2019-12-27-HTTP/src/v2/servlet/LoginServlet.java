package v2.servlet;
import v2.Request;
import v2.Response;
import v2.SessionServer;
import v2.business.User;

import java.io.IOException;

// /login?username=用户名
public class LoginServlet extends HttpServlet {
    @Override
    public void doGet(Request req, Response resp) throws IOException {
        String username = req.parameters.get("username");
        if (username == null) {
            resp.setStatus("401 Unauthorized");
            resp.println("<h1>请登陆</h1>");
            return;
        }

        User currentUser = User.findUser(username);
        if (currentUser == null) {
            resp.setStatus("401 Unauthorized");
            resp.println("<h1>该用户不存在</h1>");
            return;
        }

        String sessionId = SessionServer.put(currentUser);

        resp.setHeader("Set-Cookie", "session-id=" + sessionId + "; expires=Tue, 07-Apr-2020 08:46:16 GMT; Max-Age=8640000");
        resp.print("<h1>欢迎 " + username + "光临</h1>");
    }
}
