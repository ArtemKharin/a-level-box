package ua.kharin.jadv.jdbc;

import ua.kharin.jadv.jdbc.entity.Client;
import ua.kharin.jadv.jdbc.entity.Order;
import ua.kharin.jadv.jdbc.repository.ClientRepository;
import ua.kharin.jadv.jdbc.repository.OrderRepository;

import java.sql.Date;
import java.sql.SQLException;

import static java.lang.System.*;

public class JdbcRunner {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        ClientRepository clientRepository = new ClientRepository();
        OrderRepository orderRepository = new OrderRepository();

        createClient(clientRepository);
        printAllClients(clientRepository);
        createOrders(orderRepository);
        printAllOrdersByClientId(orderRepository, 2);

        printClientById(clientRepository, 1);
        printClientById(clientRepository, 5);
    }

    private static void printClientById(ClientRepository clientRepository, int clientId) throws SQLException {
        out.println(clientRepository.getById(clientId));
    }

    private static void createClient(ClientRepository clientRepository) throws SQLException {
        clientRepository.add(new Client("Tester", "Testerov1", Date.valueOf("1999-11-10"),false));
    }

    private static void printAllClients(ClientRepository clientRepository) throws SQLException {
        clientRepository.getAll().forEach(it -> out.println(it.toString()));
    }

    private static void printAllOrdersByClientId(OrderRepository orderRepository, int clientId) throws SQLException {
        orderRepository.getByClientId(clientId).forEach(it -> out.println(it.toString()));
    }

    private static void createOrders(OrderRepository orderRepository) throws SQLException {
        orderRepository.add(new Order(Date.valueOf("1999-11-10"), 2, 1000));
        orderRepository.add(new Order(Date.valueOf("2018-11-10"), 2, 300));
        orderRepository.add(new Order(Date.valueOf("2020-11-10"), 2, 777));
        orderRepository.add(new Order(Date.valueOf("1999-01-01"), 3, 5550));
    }
}
