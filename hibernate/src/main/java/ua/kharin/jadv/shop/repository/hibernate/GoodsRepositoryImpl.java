package ua.kharin.jadv.shop.repository.hibernate;

import ua.kharin.jadv.shop.entity.Goods;
import ua.kharin.jadv.shop.repository.GoodsRepository;

public class GoodsRepositoryImpl extends AbstractHibernateRepository<Goods> implements GoodsRepository {
    protected void init() {
        aClass = Goods.class;
    }
}
