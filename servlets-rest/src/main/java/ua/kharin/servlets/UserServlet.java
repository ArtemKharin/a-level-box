package ua.kharin.servlets;

import com.google.gson.Gson;
import ua.kharin.model.User;
import ua.kharin.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class UserServlet extends HttpServlet {

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
        if (!validateId(req)) {
            resp.sendError(400);
        } else {
            long id = Long.parseLong(req.getPathInfo().substring(1));
            User user = userService.get(id);
            if (user == null) {
                resp.sendError(404);
            } else {
                responseBody.print(gson.toJson(user));
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        User user = gson.fromJson(req.getReader(), User.class);
        if (user == null || user.getFirstName() == null || user.getId() == null) {
            resp.sendError(400);
        } else {
            userService.add(user);
            resp.setStatus(201);
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (!validateId(req)) {
            resp.sendError(400);
        } else {
            long id = Long.parseLong(req.getPathInfo().substring(1));
            userService.remove(id);
            resp.setStatus(204);
        }
    }

    @Override
    public void destroy() {
        System.out.println(getServletName() + " destroyed");
    }

    private boolean validateId(HttpServletRequest req) {
        return req.getPathInfo().matches("\\/\\d+");
    }
}
