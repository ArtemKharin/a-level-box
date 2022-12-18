package ua.kharin.dependency.good;

import ua.kharin.single.Order;

public interface MailSender {
    void sendConfirmationEmail(Order order);
}
