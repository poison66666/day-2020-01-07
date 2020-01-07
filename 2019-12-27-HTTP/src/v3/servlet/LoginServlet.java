package v3.servlet;

import v3.Request;
import v3.Response;
import v3.SessionServer;
import v3.business.User;

import java.io.IOException;

public class LoginServlet extends HttpServlet{
    @Override
    public void doGet(Request req, Response resp) throws IOException {
        String username = req.parameters.get("username");
        if(username == null){
            resp.setStatus("401 Unsuthorized");
            resp.println("<h1>请登录</h1>");
            return;
        }

        User currentUser = User.findUser(username);
        if(currentUser == null){
            resp.setStatus("401 Unsuthorized");
            resp.println("<h1>该用户不存在</h1>");
            return;
        }

        String sessionId = SessionServer.put(currentUser);

        resp.setHeader("Set-Cookie","session-id=" + sessionId + "; expires=Tue, 07-Apr-2020 08:46:16 GMT; Max-Age=8640000");
        resp.print("<h1>欢迎"+username+"光临</h1>");
    }
}
