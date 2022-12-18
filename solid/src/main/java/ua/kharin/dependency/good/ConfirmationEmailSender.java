package ua.kharin.dependency.good;

import ua.kharin.single.Order;

public class ConfirmationEmailSender implements MailSender {
    public void sendConfirmationEmail(Order order) {
        String name = order.getCustomerName();
        String email = order.getCustomerEmail();
        //TODO
    }
}
