package ua.kharin.jadv.jdbc.repository;

import java.io.IOException;
import java.io.InputStream;
import java.io.UncheckedIOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

public abstract class AbstractRepository<E, K> {
    private static final Properties properties = loadProperties();

    protected Connection createConnection() throws SQLException {
        return DriverManager.getConnection(properties.getProperty("url"), properties);
    }

    private static Properties loadProperties() {
        Properties props = new Properties();
        try (InputStream input = AbstractRepository.class.getResourceAsStream("/jdbc.properties")) {
            props.load(input);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
        return props;
    }

    public abstract boolean add(E object) throws SQLException;
    public abstract E getById(K id) throws SQLException;
    public abstract List<E> getAll() throws SQLException;
}
