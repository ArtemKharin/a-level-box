package ua.kharin.springdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.kharin.springdemo.dto.User;
import ua.kharin.springdemo.repository.UsersRepository;
import ua.kharin.springdemo.repository.model.UserEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UsersService {
    private final UsersRepository usersRepository;

    @Autowired
    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        usersRepository.findAll().forEach(it -> users.add(new User(it.getId(), it.getName(), it.getLastName(), it.getAge())));
        return users;
    }

    public User saveUser(User user) {
        UserEntity entity = usersRepository.save(new UserEntity(null, user.getName(), user.getLastName(), user.getAge()));
        return new User(entity.getId(), entity.getName(), entity.getLastName(), entity.getAge());
    }

    public void deleteUser(long id) {
        usersRepository.deleteById(id);
    }

    public Optional<User> getUser(long id) {
        return usersRepository.findById(id).map(entity -> new User(entity.getId(), entity.getName(), entity.getLastName(), entity.getAge()));
    }
}
