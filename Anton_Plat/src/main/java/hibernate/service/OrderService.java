package hibernate.service;

import hibernate.lesson10.entity.Order;
import hibernate.lesson10.entity.types.ProductQuality;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;

public interface OrderService {
    Order create(String product, ProductQuality quality, Integer amount,
                 Double price, Date creationDate);

    Order read(Long orderId);

    void update(Order order);

    void delete(Order order);

    List<Order> findAll();
}
