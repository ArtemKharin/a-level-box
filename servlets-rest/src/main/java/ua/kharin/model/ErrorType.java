package ua.kharin.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ErrorType {
    NOT_FOUND(404, "Resource not found"), BAD_REQUEST(400, "Bad request");
    private final int statusCode;
    private final String title;
}
