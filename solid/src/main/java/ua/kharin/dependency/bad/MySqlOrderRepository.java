package ua.kharin.dependency.bad;

import ua.kharin.single.MySqlConnection;
import ua.kharin.single.Order;

public class MySqlOrderRepository {
    public boolean save(Order order) {
        MySqlConnection connection = new MySqlConnection("database.url");
        // TODO
        return true;
    }
}
