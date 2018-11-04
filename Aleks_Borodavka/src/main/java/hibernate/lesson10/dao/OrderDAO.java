package hibernate.lesson10.dao;

import hibernate.lesson10.entity.Order;

import java.util.List;

public interface OrderDAO {
    Long create(Order order);

    Order read(Long id);

    boolean update(Order order);

    boolean delete(Order order);

    List<Order> findAll();
}
