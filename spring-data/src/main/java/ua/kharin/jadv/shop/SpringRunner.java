package ua.kharin.jadv.shop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.kharin.jadv.shop.entity.Client;
import ua.kharin.jadv.shop.entity.Goods;
import ua.kharin.jadv.shop.entity.Order;
import ua.kharin.jadv.shop.v2.repository.ClientRepository;
import ua.kharin.jadv.shop.v2.repository.GoodsRepository;
import ua.kharin.jadv.shop.v2.repository.OrderRepository;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Component
public class SpringRunner {
    private final ClientRepository clientRepository;
    private final GoodsRepository goodsRepository;
    private final OrderRepository orderRepository;
    private final Remover remover;

    @Autowired
    public SpringRunner(ClientRepository clientRepository, GoodsRepository goodsRepository,
                        OrderRepository orderRepository, Remover remover) {
        this.clientRepository = clientRepository;
        this.goodsRepository = goodsRepository;
        this.orderRepository = orderRepository;
        this.remover = remover;
    }

    @PostConstruct
    private void init() {
        // save a few customers
        Client client = createAndSaveClient();
        clientRepository.findAll().forEach(it -> System.out.println("1) " + it));
        System.out.println("==================================");
        remover.removeUsersYoungerThan(15);
        clientRepository.findAll().forEach(it -> System.out.println("11) " + it));
        Goods goods = createAndSaveGoods();
        goodsRepository.findAll().forEach(it -> System.out.println("2) " + it));
        //Order order = createAndSaveOrder(client, goods);
        orderRepository.findAll().forEach(it -> System.out.println("3) " + it));
        orderRepository.findAllByDiscountGreaterThan(0).forEach(it -> System.out.println("4) " + it));
    }

    private Client createAndSaveClient() {
        Client client = new Client("Tester", "Testerov", LocalDate.of(2022, 11, 29));
        return clientRepository.save(client);
    }

    private Goods createAndSaveGoods() {
        Goods goods = new Goods(BigDecimal.valueOf(2000), "Test goods", "Test category");
        return goodsRepository.save(goods);
    }

    private Order createAndSaveOrder(Client client, Goods goods) {
        Order order = new Order(LocalDateTime.now(), goods.getPrice(), null);
        order.setGoods(List.of(goods));
        order.setDiscount(5);
        order.setClient(client);
        return orderRepository.save(order);
    }
}
