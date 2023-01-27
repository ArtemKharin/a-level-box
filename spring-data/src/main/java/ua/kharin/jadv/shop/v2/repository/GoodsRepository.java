package ua.kharin.jadv.shop.v2.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.kharin.jadv.shop.entity.Goods;

@Repository
public interface GoodsRepository extends CrudRepository<Goods, String> {
}
