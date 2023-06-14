package ua.kharin;

import ua.kharin.entity.Goods;
import ua.kharin.repository.GoodsRepository;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

public class JdbcRunner {
    public static void main(String[] args) throws SQLException {
        GoodsRepository goodsRepository = new GoodsRepository();
        goodsRepository.recreateTable();

        printAllRecords(goodsRepository);

        createRecord(goodsRepository);
        createRecord(goodsRepository);

        printAllRecords(goodsRepository);

        printRecordById(goodsRepository, 1);
        printRecordById(goodsRepository, 2);
        removeRecordById(goodsRepository, 2);

        printAllRecords(goodsRepository);
    }

    private static void printRecordById(GoodsRepository goodsRepository, int id) throws SQLException {
        goodsRepository.getByID(id).ifPresentOrElse(System.out::println, () -> System.out.println("No value found with id " + id));
    }

    private static void removeRecordById(GoodsRepository goodsRepository, int id) throws SQLException {
        goodsRepository.remove(id);
    }

    private static void createRecord(GoodsRepository goodsRepository) throws SQLException {
        goodsRepository.add(new Goods("test", "test descr", BigDecimal.TEN, Timestamp.from(Instant.now())));
    }

    private static void printAllRecords(GoodsRepository goodsRepository) throws SQLException {
        List<Goods> goodsFromDB = goodsRepository.getAll();
        System.out.println(goodsFromDB);
    }
}