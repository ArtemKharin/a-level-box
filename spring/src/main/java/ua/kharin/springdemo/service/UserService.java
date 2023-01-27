package ua.kharin.springdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.kharin.springdemo.controller.model.User;
import ua.kharin.springdemo.converter.UserConverter;
import ua.kharin.springdemo.entity.UserEntity;
import ua.kharin.springdemo.repository.UserRepository;

import java.util.List;

import static ua.kharin.springdemo.converter.UserConverter.fromEntity;
import static ua.kharin.springdemo.converter.UserConverter.toEntity;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAll() {
        return userRepository.findAll().stream().map(UserConverter::fromEntity).toList();
    }

    public User getById(Long id) {
        return fromEntity(userRepository.findById(id).orElseThrow(() -> new RuntimeException("")));
    }

    public void delete(Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
        }
    }

    public User save(User user) {
        UserEntity entity;
        if (user.getId() != null && userRepository.existsById(user.getId())) {
            entity = userRepository.findById(user.getId()).get();
            entity.setCity(user.getCity());
            entity.setFirstName(user.getFirstName());
            entity.setLastName(user.getLastName());
        } else {
            entity = toEntity(user);
        }
        return fromEntity(userRepository.save(entity));
    }
}
