package ua.kharin.servlets;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class UserListServlet extends AbstractHttpServlet {

    private static final long serialVersionUID = -8948379822734246956L;

    @Override
    public void init() {
        System.out.println(getServletName() + " initialized");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.getWriter().print(gson.toJson(userService.getAll()));
        resp.setContentType(APPLICATION_JSON);
    }

    @Override
    public void destroy() {
        System.out.println(getServletName() + " destroyed");
    }
}
