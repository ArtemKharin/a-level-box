package ua.kharin.jadv.jdbc;

import ua.kharin.jadv.jdbc.entity.Client;
import ua.kharin.jadv.jdbc.repository.ClientRepository;

import java.sql.Date;
import java.sql.SQLException;

import static java.lang.System.*;

public class JdbcRunner {
    public static void main(String[] args) throws SQLException {
        ClientRepository clientRepository = new ClientRepository();
        recreateClientTable(clientRepository);
        createClient(clientRepository);
        createClient(clientRepository);

        printAllClients(clientRepository);

        printClientById(clientRepository, 1);
        printClientById(clientRepository, 5);
    }

    private static void printClientById(ClientRepository clientRepository, long clientId) throws SQLException {
        out.println(clientRepository.getById(clientId));
    }

    private static void createClient(ClientRepository clientRepository) throws SQLException {
        clientRepository.add(new Client("Tester", "Testerov1", Date.valueOf("1999-11-10"), false));
    }

    private static void recreateClientTable(ClientRepository clientRepository) throws SQLException {
        clientRepository.removeTable();
        clientRepository.createTable();
    }

    private static void printAllClients(ClientRepository clientRepository) throws SQLException {
        clientRepository.getAll().forEach(it -> out.println(it.toString()));
    }
}
