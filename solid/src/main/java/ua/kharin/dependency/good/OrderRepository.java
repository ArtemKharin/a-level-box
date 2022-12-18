package ua.kharin.dependency.good;

import ua.kharin.single.Order;

public interface OrderRepository {
    boolean save(Order order);
}
