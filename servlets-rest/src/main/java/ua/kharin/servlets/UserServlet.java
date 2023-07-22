package ua.kharin.servlets;

import org.apache.commons.lang3.StringUtils;
import ua.kharin.model.ErrorType;
import ua.kharin.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

public class UserServlet extends AbstractHttpServlet {

    private static final long serialVersionUID = -8948379822734246956L;

    @Override
    public void init() {
        System.out.println(getServletName() + " initialized");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        if (!validateId(req)) {
            throwApiError(resp, ErrorType.BAD_REQUEST, "Provided id is not valid");
        } else {
            long id = getUserId(req);
            User user = userService.get(id);
            if (user == null) {
                throwApiError(resp, ErrorType.NOT_FOUND, "User with id " + id + " not found");
            } else {
                resp.getWriter().print(gson.toJson(user));
                resp.setContentType(APPLICATION_JSON);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        User user = gson.fromJson(req.getReader(), User.class);
        if (validateUser(resp, user)) {
            userService.add(user);
            resp.setStatus(201);
        }
    }

    private boolean validateUser(HttpServletResponse resp, User user) throws IOException {
        if (Objects.isNull(user)) {
            throwApiError(resp, ErrorType.BAD_REQUEST, "User is null");
            return false;
        }
        if (Objects.isNull(user.getId()) || user.getId() < 1) {
            throwApiError(resp, ErrorType.BAD_REQUEST, "ID is null or empty");
            return false;
        }
        if (StringUtils.isBlank(user.getFirstName())) {
            throwApiError(resp, ErrorType.BAD_REQUEST, "firstName is null or empty");
            return false;
        }
        if (StringUtils.isBlank(user.getLastName())) {
            throwApiError(resp, ErrorType.BAD_REQUEST, "lastName is null or empty");
            return false;
        }
        return true;
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        if (!validateId(req)) {
            throwApiError(resp, ErrorType.BAD_REQUEST, "Provided id is not valid");
        } else {
            long id = getUserId(req);
            userService.remove(id);
            resp.setStatus(204);
        }
    }

    @Override
    public void destroy() {
        System.out.println(getServletName() + " destroyed");
    }


    private static long getUserId(HttpServletRequest req) {
        return Long.parseLong(req.getPathInfo().substring(1));
    }

    private boolean validateId(HttpServletRequest req) {
        return req.getPathInfo().matches("\\/\\d+");
    }
}
