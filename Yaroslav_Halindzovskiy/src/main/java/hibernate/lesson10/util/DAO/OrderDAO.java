package hibernate.lesson10.util.DAO;

import hibernate.lesson10.entity.Order;

import java.util.List;

public interface OrderDAO {

    Long create(Order order);
    Order read (Long id );
    boolean update(Order order);
    boolean delete (Order order);
    public List<Order> findAll();



}
