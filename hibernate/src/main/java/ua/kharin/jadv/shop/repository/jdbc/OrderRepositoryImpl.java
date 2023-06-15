package ua.kharin.jadv.shop.repository.jdbc;

import lombok.SneakyThrows;
import ua.kharin.jadv.shop.entity.Client;
import ua.kharin.jadv.shop.entity.Goods;
import ua.kharin.jadv.shop.entity.Order;
import ua.kharin.jadv.shop.repository.ClientRepository;
import ua.kharin.jadv.shop.repository.GoodsRepository;
import ua.kharin.jadv.shop.repository.OrderRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OrderRepositoryImpl extends AbstractJDBCRepository implements OrderRepository {
    private static final String CREATE_ORDER_SQL = "INSERT INTO orders (order_id, date, total_price, discount, client_id) VALUES (?,?,?,?,?)";
    private static final String CREATE_ORDER_GOODS_RECORD_SQL = "INSERT INTO orders_goods (order_id, goods_id) VALUES (?,?)";
    private static final String SELECT_ALL_ORDERS_SQL = "SELECT * FROM orders";
    private static final String SELECT_ALL_ORDERS_WITH_DISCOUNT_SQL = "SELECT * FROM orders WHERE discount > 0";
    private static final String SELECT_ORDER_BY_ID_SQL = "SELECT * FROM orders WHERE order_id = ?";
    private static final String SELECT_GOODS_ID_BY_ORDER_ID_SQL = "SELECT goods_id FROM orders_goods WHERE order_id = ?";
    private GoodsRepository goodsRepository;
    private ClientRepository clientRepository;

    public OrderRepositoryImpl(GoodsRepository goodsRepository, ClientRepository clientRepository) {
        this.goodsRepository = goodsRepository;
        this.clientRepository = clientRepository;
    }

    @SneakyThrows
    @Override
    public Order getById(String id) {
        try (Connection connection = createConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_ORDER_BY_ID_SQL)) {
            statement.setString(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    Order order = extractOrderFromResultSet(resultSet);
                    order.setClient(getClientDataFromOrderResultSet(resultSet));
                    order.setGoods(getGoodsDataFromOrder(order.getId()));
                    return order;
                }
                return null;
            }
        }
    }

    @SneakyThrows
    @Override
    public List<Order> getAll() {
        List<Order> orders = new ArrayList<>();
        try (Connection connection = createConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(SELECT_ALL_ORDERS_SQL)) {
            while (resultSet.next()) {
                Order order = extractOrderFromResultSet(resultSet);
                order.setClient(getClientDataFromOrderResultSet(resultSet));
                order.setGoods(getGoodsDataFromOrder(order.getId()));
                orders.add(order);
            }
            return orders;
        }
    }

    @SneakyThrows
    @Override
    public void save(Order order) {
        try (Connection connection = createConnection();
             PreparedStatement orderStatement = connection.prepareStatement(CREATE_ORDER_SQL);
             PreparedStatement orderGoodsStatement = connection.prepareStatement(CREATE_ORDER_GOODS_RECORD_SQL)) {
            orderStatement.setString(1, order.getId());
            orderStatement.setTimestamp(2, Timestamp.valueOf(order.getDate()));
            orderStatement.setBigDecimal(3, order.getTotalPrice());
            orderStatement.setInt(4, Optional.ofNullable(order.getDiscount()).orElse(0));
            orderStatement.setString(5, order.getClient().getId());
            orderStatement.execute();
            order.getGoods().forEach(goods -> saveOrderGoodsRecord(orderGoodsStatement, order.getId(), goods.getId()));
        }
    }

    private void saveOrderGoodsRecord(PreparedStatement statement, String orderId, String goodsId) {
        try {
            statement.setString(1, orderId);
            statement.setString(2, goodsId);
            statement.execute();
        } catch (SQLException exception) {
            System.err.println("Failed to save record to order_goods table" + exception);
        }
    }

    private Order extractOrderFromResultSet(ResultSet resultSet) throws SQLException {
        Order order = new Order();
        order.setId(resultSet.getString("order_id"));
        order.setDate(resultSet.getTimestamp("date").toLocalDateTime());
        order.setTotalPrice(resultSet.getBigDecimal("total_price"));
        order.setDiscount(resultSet.getInt("discount"));
        return order;
    }

    private Client getClientDataFromOrderResultSet(ResultSet resultSet) throws SQLException {
        return clientRepository.getById(resultSet.getString("client_id"));
    }

    @SneakyThrows
    private List<Goods> getGoodsDataFromOrder(String orderId) {
        List<Goods> goodsList = new ArrayList<>();
        try (Connection connection = createConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_GOODS_ID_BY_ORDER_ID_SQL)) {
            statement.setString(1, orderId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String goodsId = resultSet.getString("goods_id");
                goodsList.add(goodsRepository.getById(goodsId));
            }
            return goodsList;
        }
    }

    @SneakyThrows
    @Override
    public List<Order> getOrdersWithDiscount() {
        List<Order> orders = new ArrayList<>();
        try (Connection connection = createConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(SELECT_ALL_ORDERS_WITH_DISCOUNT_SQL)) {
            while (resultSet.next()) {
                Order order = extractOrderFromResultSet(resultSet);
                order.setClient(getClientDataFromOrderResultSet(resultSet));
                order.setGoods(getGoodsDataFromOrder(order.getId()));
                orders.add(order);
            }
            return orders;
        }
    }
}
