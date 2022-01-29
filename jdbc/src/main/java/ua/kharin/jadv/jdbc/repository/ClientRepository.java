package ua.kharin.jadv.jdbc.repository;

import ua.kharin.jadv.jdbc.entity.Client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ClientRepository extends AbstractRepository<Client, Long> {
    private final String createUserSQL = "INSERT INTO public.clients (first_name, last_name, date_of_birth, registered) VALUES (?,?,?,?)";
    private final String selectAllClientsSQL = "SELECT * FROM public.clients ORDER BY client_id";
    private final String selectClientByIdSQL = "SELECT * FROM public.clients WHERE client_id = ?";
    private final String deleteTableSQL = "DROP TABLE IF EXISTS public.clients;";
    private final String createTableSQL = "CREATE TABLE public.clients\n" +
            "(\n" +
            "    client_id serial NOT NULL,\n" +
            "    first_name text NOT NULL,\n" +
            "    last_name text NOT NULL,\n" +
            "    date_of_birth date NOT NULL,\n" +
            "    registered boolean NOT NULL,\n" +
            "    PRIMARY KEY (client_id)\n" +
            ");\n" +
            "\n" +
            "ALTER TABLE IF EXISTS public.client\n" +
            "    OWNER to postgres;";

    @Override
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

    @Override
    public Client getById(Long id) throws SQLException {
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

    @Override
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

    public void removeTable() throws SQLException {
        try (Connection connection = createConnection();
             Statement statement = connection.createStatement()) {
            statement.execute(deleteTableSQL);
        }
    }

    public void createTable() throws SQLException {
        try (Connection connection = createConnection();
             Statement statement = connection.createStatement()) {
            statement.execute(deleteTableSQL);

            statement.execute(createTableSQL);
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
}
