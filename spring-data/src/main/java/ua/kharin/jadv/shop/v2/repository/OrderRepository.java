package ua.kharin.jadv.shop.v2.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.kharin.jadv.shop.entity.Order;

import java.util.List;

@Repository
public interface OrderRepository extends CrudRepository<Order, String> {
    List<Order> findAllByDiscountGreaterThan(int minDiscount);
}
