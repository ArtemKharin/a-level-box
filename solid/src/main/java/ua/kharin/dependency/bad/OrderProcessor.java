package ua.kharin.dependency.bad;

import ua.kharin.single.Order;

public class OrderProcessor {
    public void process(Order order) {
        MySqlOrderRepository repository = new MySqlOrderRepository();
        ConfirmationEmailSender emailSender = new ConfirmationEmailSender();
        if (order.isValid() && repository.save(order)) {
            emailSender.sendConfirmationEmail(order);
        }
    }
}
