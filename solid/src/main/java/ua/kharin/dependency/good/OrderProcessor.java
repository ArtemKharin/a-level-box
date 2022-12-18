package ua.kharin.dependency.good;

import ua.kharin.single.Order;

public class OrderProcessor {
    private MailSender mailSender;
    private OrderRepository repository;

    public void setMailSender(MailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void setRepository(OrderRepository repository) {
        this.repository = repository;
    }

    public void process(Order order) {
        if (order.isValid() && repository.save(order)) {
            mailSender.sendConfirmationEmail(order);
        }
    }
}
