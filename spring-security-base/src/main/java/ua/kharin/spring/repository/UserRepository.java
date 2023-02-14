package ua.kharin.spring.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.kharin.spring.entity.UserEntity;

import java.util.List;
import java.util.Set;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {
    List<UserEntity> findAll();

    Set<UserEntity> findAllByCity(String city);

    List<UserEntity> findAllByFirstNameStartsWith(String prefix);
    @Query(nativeQuery = true, value = "select * from users where first_name like ?1")
    List<UserEntity> findAllWithNameStarts(String prefix);
}
