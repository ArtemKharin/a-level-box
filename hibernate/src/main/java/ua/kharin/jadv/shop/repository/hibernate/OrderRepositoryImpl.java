package ua.kharin.jadv.shop.repository.hibernate;

import ua.kharin.jadv.shop.config.HibernateUtils;
import ua.kharin.jadv.shop.entity.Order;
import ua.kharin.jadv.shop.repository.OrderRepository;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class OrderRepositoryImpl extends AbstractHibernateRepository<Order> implements OrderRepository {
    protected void init() {
        aClass = Order.class;
    }

    @Override
    public List<Order> getOrdersWithDiscount() {
        EntityManager entityManager = HibernateUtils.getEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Order> query = criteriaBuilder.createQuery(aClass);
        Root<Order> from = query.from(aClass);
        query.select(from).where(criteriaBuilder.greaterThan(from.get("discount"), 0));
        return entityManager.createQuery(query).getResultList();
    }
}
