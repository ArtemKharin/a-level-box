package ua.kharin.servlets;

import com.google.gson.Gson;
import ua.kharin.model.ApiError;
import ua.kharin.model.ErrorType;
import ua.kharin.service.UserService;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public abstract class AbstractHttpServlet extends HttpServlet {
    public static final String APPLICATION_JSON = "application/json";
    protected final UserService userService = UserService.getInstance();
    protected final Gson gson = new Gson();

    protected void throwApiError(HttpServletResponse resp, ErrorType errorType, String message) throws IOException {
        ApiError apiError = new ApiError(errorType.getTitle(), message);
        resp.getWriter().println(gson.toJson(apiError));
        resp.setContentType(APPLICATION_JSON);
        resp.setStatus(errorType.getStatusCode());
    }
}
