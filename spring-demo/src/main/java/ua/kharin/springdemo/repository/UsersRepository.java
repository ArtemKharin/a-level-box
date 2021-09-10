package ua.kharin.springdemo.repository;

import org.springframework.data.repository.CrudRepository;
import ua.kharin.springdemo.repository.model.UserEntity;

public interface UsersRepository extends CrudRepository<UserEntity, Long> {
}
