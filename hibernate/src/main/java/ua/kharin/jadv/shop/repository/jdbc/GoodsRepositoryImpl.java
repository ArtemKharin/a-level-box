package ua.kharin.jadv.shop.repository.jdbc;

import lombok.SneakyThrows;
import ua.kharin.jadv.shop.entity.Goods;
import ua.kharin.jadv.shop.repository.GoodsRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GoodsRepositoryImpl extends AbstractJDBCRepository implements GoodsRepository {
    private static final String INSERT_GOODS_SQL = "INSERT INTO goods (goods_id, price, title, category) VALUES (?,?,?,?)";
    private static final String SELECT_ALL_GOODS_SQL = "SELECT * FROM goods";
    private static final String SELECT_GOODS_BY_ID_SQL = "SELECT * FROM goods WHERE goods_id = ?";

    @SneakyThrows
    @Override
    public Goods getById(String id) {
        try (Connection connection = createConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_GOODS_BY_ID_SQL)) {
            statement.setString(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return extractGoodsFromResultSet(resultSet);
                }
                return null;
            }
        }
    }

    @SneakyThrows
    @Override
    public List<Goods> getAll() {
        List<Goods> goods = new ArrayList<>();
        try (Connection connection = createConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(SELECT_ALL_GOODS_SQL)) {
            while (resultSet.next()) {
                goods.add(extractGoodsFromResultSet(resultSet));
            }
            return goods;
        }
    }

    @SneakyThrows
    @Override
    public void save(Goods goods) {
        try (Connection connection = createConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT_GOODS_SQL)) {
            statement.setString(1, goods.getId());
            statement.setBigDecimal(2, goods.getPrice());
            statement.setString(3, goods.getTitle());
            statement.setString(4, goods.getCategory());
            statement.execute();
        }
    }

    private Goods extractGoodsFromResultSet(ResultSet resultSet) throws SQLException {
        Goods goods = new Goods();
        goods.setId(resultSet.getString("goods_id"));
        goods.setPrice(resultSet.getBigDecimal("price"));
        goods.setTitle(resultSet.getString("title"));
        goods.setCategory(resultSet.getString("category"));
        return goods;
    }
}
