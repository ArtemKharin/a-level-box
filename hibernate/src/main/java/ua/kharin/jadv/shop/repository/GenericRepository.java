package ua.kharin.jadv.shop.repository;

import java.util.List;

public interface GenericRepository<T> {
    T getById(String id);

    List<T> getAll();

    void save(T client);
}
