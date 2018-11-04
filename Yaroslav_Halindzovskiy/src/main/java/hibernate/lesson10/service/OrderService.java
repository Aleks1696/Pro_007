package hibernate.lesson10.service;

import hibernate.lesson10.entity.Order;
import hibernate.lesson10.entity.ProductQality;

import java.util.Date;
import java.util.List;

public interface OrderService {
    Order create(String name,ProductQality product, Integer amount, Double price, Date creationDate);

    Order read (Long orderId);

    void update(Order order);
    void delete (Order order);

    List<Order> findAll();

}
