package ua.kharin.repository;

import java.io.IOException;
import java.io.InputStream;
import java.io.UncheckedIOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

public abstract class AbstractRepository<T, K> {
    private static final Properties PROPERTIES = loadProperties();

    protected Connection createConnection() throws SQLException {
        return DriverManager.getConnection(PROPERTIES.getProperty("url"), PROPERTIES.getProperty("user"), PROPERTIES.getProperty("password"));
    }

    public abstract Optional<T> getByID(K id) throws SQLException;

    public abstract List<T> getAll() throws SQLException;

    public abstract boolean add(T entity) throws SQLException;

    public abstract void remove(K id) throws SQLException;

    private static Properties loadProperties() {
        Properties properties = new Properties();
        try (InputStream inputStream = AbstractRepository.class.getResourceAsStream("/jdbc.properties")) {
            properties.load(inputStream);
        } catch (IOException e) {
            System.err.println("Cannot load jdbc properties");
            throw new UncheckedIOException(e);
        }
        return properties;
    }
}
