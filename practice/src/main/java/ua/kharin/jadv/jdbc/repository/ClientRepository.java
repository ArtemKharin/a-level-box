package ua.kharin.jadv.jdbc.repository;

import ua.kharin.jadv.jdbc.entity.Client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ClientRepository extends AbstractRepository {
    private String createUserSQL = "INSERT INTO practice.clients (first_name, last_name, date_of_birth, registered) VALUES (?,?,?,?)";
    private String selectAllClientsSQL = "SELECT * FROM practice.clients ORDER BY client_id";
    private String selectClientByIdSQL = "SELECT * FROM practice.clients WHERE client_id = ?";

    public boolean add(Client client) throws SQLException {
        try (Connection connection = createConnection();
             PreparedStatement statement = connection.prepareStatement(createUserSQL)) {
            statement.setString(1, client.getFirstName());
            statement.setString(2, client.getLastName());
            statement.setDate(3, client.getDateOfBirth());
            statement.setBoolean(4, client.isRegistered());
            return statement.execute();
        }
    }

    public Client getById(long id) throws SQLException {
        try (Connection connection = createConnection();
             PreparedStatement statement = connection.prepareStatement(selectClientByIdSQL)) {
            statement.setLong(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return extractClientFromResultSet(resultSet);
                }
                return null;
            }

        }
    }

    private Client extractClientFromResultSet(ResultSet resultSet) throws SQLException {
        Client client = new Client();
        client.setClientId(resultSet.getLong("client_id"));
        client.setFirstName(resultSet.getString(2));
        client.setLastName(resultSet.getString(3));
        client.setDateOfBirth(resultSet.getDate(4));
        client.setRegistered(resultSet.getBoolean(5));
        return client;
    }

    public List<Client> getAll() throws SQLException {
        List<Client> clients = new ArrayList<>();
        try (Connection connection = createConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(selectAllClientsSQL)) {
            while (resultSet.next()) {
                clients.add(extractClientFromResultSet(resultSet));
            }
            return clients;
        }
    }
}
