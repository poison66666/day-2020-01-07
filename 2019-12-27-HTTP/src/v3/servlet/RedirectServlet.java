package v3.servlet;

import v3.Request;
import v3.Response;

import java.io.IOException;

public class RedirectServlet extends HttpServlet{
    @Override
    public void doGet(Request req, Response resp) throws IOException {
        resp.setStatus("307 Temporary Redirect");
        resp.setHeader("Location","http://www.qq.com/");
    }
}
