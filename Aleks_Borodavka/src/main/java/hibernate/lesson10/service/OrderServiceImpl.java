package hibernate.lesson10.service;

import hibernate.lesson10.dao.OrderDAO;
import hibernate.lesson10.dao.OrderDAOImp;
import hibernate.lesson10.entity.Order;
import hibernate.lesson10.entity.types.ProductQuality;
import java.util.Date;
import java.util.List;

public class OrderServiceImpl implements OrderService {

    private OrderDAO dao;

    public OrderServiceImpl(){
        dao = new OrderDAOImp();
    }

    @Override
    public Order create(String product, ProductQuality quality, Integer amount,
                        Double price, Date creationDate) {
        if (product != null & quality != null & amount != null &
                price != null & creationDate != null){
            Order order = new Order(product, quality, amount, price, creationDate);
            order.setId(dao.create(order));
            return order;
        }
        throw new IllegalStateException();
    }

    @Override
    public Order read(Long orderId) {
        if (orderId != null) {
            return dao.read(orderId);
        }
        return null;
    }

    @Override
    public void update(Order order) {
        if (dao.update(order)){
            System.out.println("Updated");
        } else {
            System.out.println("Crash");
        }
    }

    @Override
    public void delete(Order order) {
        if (dao.delete(order)){
            System.out.println("Deleted");
        } else {
            System.out.println("Crash");
        }
    }

    @Override
    public List<Order> findAll() {
        return dao.findAll();
    }
}
