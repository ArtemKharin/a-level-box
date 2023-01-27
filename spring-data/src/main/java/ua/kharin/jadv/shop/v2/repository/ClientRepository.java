package ua.kharin.jadv.shop.v2.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.kharin.jadv.shop.entity.Client;

import java.time.LocalDate;

@Repository
public interface ClientRepository extends CrudRepository<Client, String> {
    int removeAllByDateOfBirthAfter(LocalDate date);
}
