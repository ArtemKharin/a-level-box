package ua.kharin.servlets;

import com.google.gson.Gson;
import ua.kharin.service.UserService;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class UserListServlet extends HttpServlet {

    private static final long serialVersionUID = -8948379822734246956L;
    private UserService userService;
    private Gson gson = new Gson();

    @Override
    public void init() {
        userService = UserService.getInstance();
        System.out.println(getServletName() + " initialized");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        PrintWriter responseBody = resp.getWriter();
        responseBody.print(gson.toJson(userService.getAll()));
    }


    @Override
    public void destroy() {
        System.out.println(getServletName() + " destroyed");
    }
}
