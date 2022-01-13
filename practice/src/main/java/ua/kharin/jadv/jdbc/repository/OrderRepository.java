package ua.kharin.jadv.jdbc.repository;

import ua.kharin.jadv.jdbc.entity.Order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderRepository extends AbstractRepository {
    private String createOrderSQL = "INSERT INTO practice.order (date, price, client_id) VALUES (?,?,?)";
    private String selectOrderByClientIdSQL = "SELECT * FROM practice.order WHERE client_id = ?";

    public boolean add(Order order) throws SQLException {
        try (Connection connection = createConnection();
             PreparedStatement statement = connection.prepareStatement(createOrderSQL)) {
            statement.setDate(1, order.getDate());
            statement.setDouble(2, order.getPrice());
            statement.setLong(3, order.getClientId());
            return statement.execute();
        }
    }

    public List<Order> getByClientId(long clientId) throws SQLException {
        try (Connection connection = createConnection();
             PreparedStatement statement = connection.prepareStatement(selectOrderByClientIdSQL)) {
            statement.setLong(1, clientId);
            try (ResultSet resultSet = statement.executeQuery()) {
                List<Order> orders = new ArrayList<>();
                while (resultSet.next()) {
                    Order order = new Order();
                    order.setOrderId(resultSet.getLong(1));
                    order.setDate(resultSet.getDate(2));
                    order.setPrice(resultSet.getDouble(3));
                    order.setClientId(resultSet.getLong(4));
                    orders.add(order);
                }
                return orders;
            }

        }
    }
}
