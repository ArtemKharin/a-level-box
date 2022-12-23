package ua.kharin.jadv.shop;

import ua.kharin.jadv.shop.entity.Client;
import ua.kharin.jadv.shop.entity.Goods;
import ua.kharin.jadv.shop.entity.Order;
import ua.kharin.jadv.shop.repository.ClientRepository;
import ua.kharin.jadv.shop.repository.GoodsRepository;
import ua.kharin.jadv.shop.repository.OrderRepository;
import ua.kharin.jadv.shop.repository.hibernate.ClientRepositoryImpl;
import ua.kharin.jadv.shop.repository.hibernate.GoodsRepositoryImpl;
import ua.kharin.jadv.shop.repository.hibernate.OrderRepositoryImpl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class HibernateRunner {
    private static final ClientRepository clientRepository = new ClientRepositoryImpl();
    private static final GoodsRepository goodsRepository = new GoodsRepositoryImpl();
    private static final OrderRepository orderRepository = new OrderRepositoryImpl();

    public static void main(String[] args) {
        Client client = createAndSaveClient();
        clientRepository.getAll().forEach(System.out::println);
        Goods goods = createAndSaveGoods();
        goodsRepository.getAll().forEach(System.out::println);
        Order order = createAndSaveOrder(client, goods);
        orderRepository.getAll().forEach(System.out::println);
    }

    private static Client createAndSaveClient() {
        Client client = new Client("Tester", "Testerov", LocalDate.of(2022, 11, 29));
        clientRepository.save(client);
        return client;
    }

    private static Goods createAndSaveGoods() {
        Goods goods = new Goods(BigDecimal.valueOf(2000), "Test goods", "Test category");
        goodsRepository.save(goods);
        return goods;
    }

    private static Order createAndSaveOrder(Client client, Goods goods) {
        Order order = new Order(LocalDateTime.now(), goods.getPrice(), null);
        order.setGoods(List.of(goods));
        order.setClient(client);
        orderRepository.save(order);
        return order;
    }
}
