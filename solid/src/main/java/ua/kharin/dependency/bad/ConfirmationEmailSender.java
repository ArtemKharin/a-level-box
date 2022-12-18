package ua.kharin.dependency.bad;

import ua.kharin.single.Order;

public class ConfirmationEmailSender {
    public void sendConfirmationEmail(Order order) {
        String name = order.getCustomerName();
        String email = order.getCustomerEmail();
        //TODO
    }
}
