package ua.kharin.jadv.shop;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ua.kharin.jadv.shop.v2.repository.ClientRepository;

import java.time.LocalDate;

@Component
public class Remover {
    private final ClientRepository clientRepository;

    public Remover(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Transactional
    public void removeUsersYoungerThan(int age) {
        clientRepository.removeAllByDateOfBirthAfter(LocalDate.now().minusYears(age));
    }
}
