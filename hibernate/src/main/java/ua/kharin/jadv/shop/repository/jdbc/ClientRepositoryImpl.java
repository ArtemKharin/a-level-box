package ua.kharin.jadv.shop.repository.jdbc;

import lombok.SneakyThrows;
import ua.kharin.jadv.shop.entity.Client;
import ua.kharin.jadv.shop.repository.ClientRepository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ClientRepositoryImpl extends AbstractJDBCRepository implements ClientRepository {
    private static final String CREATE_USER_SQL = "INSERT INTO clients (client_id, first_name, last_name, date_of_birth) VALUES (?,?,?,?)";
    private static final String SELECT_ALL_CLIENTS_SQL = "SELECT * FROM clients";
    private static final String SELECT_CLIENT_BY_ID_SQL = "SELECT * FROM clients WHERE client_id = ?";

    @SneakyThrows
    @Override
    public Client getById(String id) {
        try (Connection connection = createConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_CLIENT_BY_ID_SQL)) {
            statement.setString(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return extractClientFromResultSet(resultSet);
                }
                return null;
            }
        }
    }

    @SneakyThrows
    @Override
    public List<Client> getAll() {
        List<Client> clients = new ArrayList<>();
        try (Connection connection = createConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(SELECT_ALL_CLIENTS_SQL)) {
            while (resultSet.next()) {
                clients.add(extractClientFromResultSet(resultSet));
            }
            return clients;
        }
    }

    @SneakyThrows
    @Override
    public void save(Client client) {
        try (Connection connection = createConnection();
             PreparedStatement statement = connection.prepareStatement(CREATE_USER_SQL)) {
            statement.setString(1, client.getId());
            statement.setString(2, client.getFirstName());
            statement.setString(3, client.getLastName());
            statement.setDate(4, Date.valueOf(client.getDateOfBirth()));
            statement.execute();
        }
    }

    private Client extractClientFromResultSet(ResultSet resultSet) throws SQLException {
        Client client = new Client();
        client.setId(resultSet.getString("client_id"));
        client.setFirstName(resultSet.getString("first_name"));
        client.setLastName(resultSet.getString("last_name"));
        client.setDateOfBirth(resultSet.getDate("date_of_birth").toLocalDate());
        return client;
    }
}
