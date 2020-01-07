package v3.servlet;

import v3.Request;
import v3.Response;

import java.io.IOException;

public abstract class HttpServlet {
    public abstract void doGet(Request req, Response resp) throws IOException;
}
