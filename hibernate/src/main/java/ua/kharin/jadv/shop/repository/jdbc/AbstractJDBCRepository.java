package ua.kharin.jadv.shop.repository.jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.io.UncheckedIOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public abstract class AbstractJDBCRepository {
    private static final Properties properties = loadProperties();

    protected Connection createConnection() throws SQLException {
        return DriverManager.getConnection(properties.getProperty("url"), properties);
    }

    private static Properties loadProperties() {
        Properties props = new Properties();
        try (InputStream input = AbstractJDBCRepository.class.getResourceAsStream("/jdbc.properties")) {
            props.load(input);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
        return props;
    }
}
