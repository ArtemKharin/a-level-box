package ua.kharin.repository;

import ua.kharin.entity.Goods;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class GoodsRepository extends AbstractRepository<Goods, Integer> {
    private static final String CREATE_TABLE_SQL = """
            CREATE TABLE goods (
              `id` INT NOT NULL AUTO_INCREMENT,
              `title` VARCHAR(32) NOT NULL,
              `description` VARCHAR(256) NULL,
              `price` DECIMAL(6,2) NOT NULL,
              `last_modified` TIMESTAMP NULL,
              PRIMARY KEY (`id`),
              UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE);
            """;

    private static final String DELETE_TABLE_SQL = "DROP TABLE IF EXISTS goods;";

    private static final String GET_ALL_SQL = "select * from goods";
    private static final String GET_BY_ID_SQL = "select * from goods where id = ?";
    private static final String REMOVE_BY_ID_SQL = "delete from goods where id = ?";
    private static final String INSERT_SQL = "insert into goods (title, description, price, last_modified) values (?,?,?,?)";

    @Override
    public Optional<Goods> getByID(Integer id) throws SQLException {
        try (Connection connection = createConnection();
             PreparedStatement statement = connection.prepareStatement(GET_BY_ID_SQL)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return Optional.of(extractEntityFromResultSet(resultSet));
                }
                return Optional.empty();
            }
        }
    }

    private static Goods extractEntityFromResultSet(ResultSet resultSet) throws SQLException {
        Goods goods = new Goods();
        goods.setId(resultSet.getInt("id"));
        goods.setTitle(resultSet.getString(2));
        goods.setDescription(resultSet.getString(3));
        goods.setPrice(resultSet.getBigDecimal(4));
        goods.setLastModified(resultSet.getTimestamp(5));
        return goods;
    }

    @Override
    public List<Goods> getAll() throws SQLException {
        List<Goods> goods = new ArrayList<>();
        try (Connection connection = createConnection();
             PreparedStatement statement = connection.prepareStatement(GET_ALL_SQL)) {
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    goods.add(extractEntityFromResultSet(resultSet));
                }
            }
        }
        return goods;
    }

    @Override
    public boolean add(Goods entity) throws SQLException {
        try (Connection connection = createConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT_SQL)) {
            statement.setString(1, entity.getTitle());
            statement.setString(2, entity.getDescription());
            statement.setBigDecimal(3, entity.getPrice());
            statement.setTimestamp(4, entity.getLastModified());
            return statement.execute();
        }
    }

    @Override
    public void remove(Integer id) throws SQLException {
        try (Connection connection = createConnection();
             PreparedStatement statement = connection.prepareStatement(REMOVE_BY_ID_SQL)) {
            statement.setInt(1, id);
            statement.execute();
        }
    }

    public void recreateTable() throws SQLException {
        try (Connection connection = createConnection();
             Statement statement = connection.createStatement()) {
            statement.execute(DELETE_TABLE_SQL);
            statement.execute(CREATE_TABLE_SQL);
        }
    }
}
