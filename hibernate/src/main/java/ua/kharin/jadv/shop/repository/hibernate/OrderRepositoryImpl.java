package ua.kharin.jadv.shop.repository.hibernate;

import ua.kharin.jadv.shop.entity.Order;
import ua.kharin.jadv.shop.repository.OrderRepository;

public class OrderRepositoryImpl extends AbstractHibernateRepository<Order> implements OrderRepository {
    protected void init() {
        aClass = Order.class;
    }
}
