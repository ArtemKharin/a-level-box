package ua.kharin.dependency.good;

import ua.kharin.single.MySqlConnection;
import ua.kharin.single.Order;

public class MySqlOrderRepository implements OrderRepository {
    public boolean save(Order order) {
        MySqlConnection connection = new MySqlConnection("database.url");
        // TODO
        return true;
    }
}
