package ua.kharin.servlets;


import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class SampleServlet extends HttpServlet {

    private static final long serialVersionUID = -8948379822734246956L;

    @Override
    public void init() {
        System.out.println(getServletName() + " initialized");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        PrintWriter responseBody = resp.getWriter();

        resp.setContentType("text/html");
        responseBody.println("<h1 align=\"center\">Sample Servlet GET method processing</h1>");
        responseBody.println("<img src=\"" + req.getContextPath() + "/img/picture.jpg\">");
        responseBody.println("<h3 align=\"center\">Request from: " + req.getRemoteHost() + "</h3>");

        String client = req.getParameter("client");
        if (client == null) {
            client = "anonymous user";
        }

        responseBody.println("<h3 align=\"center\">Hi, " + client + " </h3>");
    }

    @Override
    public void destroy() {
        System.out.println(getServletName() + " destroyed");
    }
}
