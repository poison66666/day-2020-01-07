package v3.servlet;

import v3.Request;
import v3.Response;

import java.io.IOException;

public class RunServlet extends HttpServlet{
    @Override
    public void doGet(Request req, Response resp) throws IOException {
        resp.println("<script src='joke.js'></srcipt>");
    }
}
