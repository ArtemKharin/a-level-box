package ua.kharin.service;

import ua.kharin.model.User;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public final class UserService {
    private static UserService instance;

    private UserService() {
    }

    public static synchronized UserService getInstance() {
        if (instance == null) {
            instance = new UserService();
        }
        return instance;
    }

    private Map<Long, User> users = new HashMap<>();

    public User get(long id) {
        return users.get(id);
    }

    public void add(User user) {
        users.put(user.getId(), user);
    }

    public void remove(long id) {
        users.remove(id);
    }

    public Collection<User> getAll() {
        return users.values();
    }
}
