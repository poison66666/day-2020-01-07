package v3.servlet;

import v3.Request;
import v3.Response;

import java.io.IOException;

public class JokeJSServlet extends HttpServlet{

    @Override
    public void doGet(Request req, Response resp) throws IOException {
        resp.setHeader("Content-Type","application/javascript; charset=UTF-8");
        resp.println("alert('你好');");
    }
}
