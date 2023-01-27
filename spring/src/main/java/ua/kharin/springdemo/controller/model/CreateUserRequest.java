package ua.kharin.springdemo.controller.model;

import lombok.Data;

@Data
public class CreateUserRequest {
    private String firstName;
    private String lastName;
    private String city;
}
