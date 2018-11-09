package hibernate.lesson10.service;

import hibernate.lesson10.entity.Order;
import hibernate.lesson10.entity.types.ProductQuality;

import java.util.Date;
import java.util.List;

public interface OrderService {

    Order create (String product, ProductQuality quality, Integer amount,
                  Double price, Date creationDate);

    Order read(Long orderId);

    void update(Order order);

    void delete(Order order);

    List<Order> findAll();
}
