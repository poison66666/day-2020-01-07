package v3.servlet;

import v3.Request;
import v3.Response;

import java.io.IOException;

public class PlainTextServlet extends HttpServlet{

    @Override
    public void doGet(Request req, Response resp) throws IOException {
        //resp.setHeader("Content-Type","text/plain; charset=UTF-8");
        resp.println("<h1>我不是html元素</h1>");
    }
}
