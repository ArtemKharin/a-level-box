package ua.kharin.jadv.shop;

import ua.kharin.jadv.shop.entity.Client;
import ua.kharin.jadv.shop.entity.Goods;
import ua.kharin.jadv.shop.entity.Order;
import ua.kharin.jadv.shop.repository.ClientRepository;
import ua.kharin.jadv.shop.repository.GoodsRepository;
import ua.kharin.jadv.shop.repository.OrderRepository;
import ua.kharin.jadv.shop.repository.jdbc.ClientRepositoryImpl;
import ua.kharin.jadv.shop.repository.jdbc.GoodsRepositoryImpl;
import ua.kharin.jadv.shop.repository.jdbc.OrderRepositoryImpl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class JdbcRunner {
    private static final ClientRepository clientRepository = new ClientRepositoryImpl();
    private static final GoodsRepository goodsRepository = new GoodsRepositoryImpl();
    private static final OrderRepository orderRepository = new OrderRepositoryImpl(goodsRepository, clientRepository);

    public static void main(String[] args) {
        Client client = createAndSaveClient();
        clientRepository.getAll().forEach(System.out::println);
        Goods goods = createAndSaveGoods();
        goodsRepository.getAll().forEach(System.out::println);
        Order order = createAndSaveOrder(client, goods);
        orderRepository.getAll().forEach(System.out::println);

        System.out.println(orderRepository.getOrdersWithDiscount());
    }

    private static Client createAndSaveClient() {
        Client client = new Client(UUID.randomUUID().toString(), "Tester", "Testerov", LocalDate.of(2022, 11, 29), Collections.emptyList());
        clientRepository.save(client);
        return client;
    }

    private static Goods createAndSaveGoods() {
        Goods goods = new Goods(UUID.randomUUID().toString(), BigDecimal.valueOf(2000), "Test goods", "Test category", List.of());
        goodsRepository.save(goods);
        return goods;
    }

    private static Order createAndSaveOrder(Client client, Goods goods) {
        Order order = new Order(UUID.randomUUID().toString(), LocalDateTime.now(), goods.getPrice(), null, client, List.of(goods));
        orderRepository.save(order);
        return order;
    }
}
