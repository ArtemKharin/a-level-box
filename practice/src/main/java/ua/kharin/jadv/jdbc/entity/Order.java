package ua.kharin.jadv.jdbc.entity;

import java.sql.Date;

public class Order {
    private long orderId;
    private Date date;
    private long clientId;
    private double price;

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public long getClientId() {
        return clientId;
    }

    public void setClientId(long clientId) {
        this.clientId = clientId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Order(Date date, long clientId, double price) {
        this.date = date;
        this.clientId = clientId;
        this.price = price;
    }

    public Order() {
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", date=" + date +
                ", clientId=" + clientId +
                ", price=" + price +
                '}';
    }
}
