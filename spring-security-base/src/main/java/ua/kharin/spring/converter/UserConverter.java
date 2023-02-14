package ua.kharin.spring.converter;

import ua.kharin.spring.controller.model.User;
import ua.kharin.spring.entity.UserEntity;

public class UserConverter {
    public static User fromEntity(UserEntity entity) {
        return new User(entity.getId(), entity.getFirstName(), entity.getLastName(), entity.getCity());
    }

    public static UserEntity toEntity(User user) {
        return new UserEntity(user.getFirstName(), user.getLastName(), user.getCity());
    }
}
