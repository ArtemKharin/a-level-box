package ua.kharin.single.bad;

import ua.kharin.single.MySqlConnection;
import ua.kharin.single.Order;

public class OrderProcessor {
    public void process(Order order) {
        if (order.isValid() && save(order)) {
            sendConfirmationEmail(order);
        }
    }

    private boolean save(Order order) {
        MySqlConnection connection = new MySqlConnection("database.url");
        // TODO
        return true;
    }

    private void sendConfirmationEmail(Order order) {
        String name = order.getCustomerName();
        String email = order.getCustomerEmail();
        //TODO
    }
}
