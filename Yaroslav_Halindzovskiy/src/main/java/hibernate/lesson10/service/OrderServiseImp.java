package hibernate.lesson10.service;

import hibernate.lesson10.entity.Order;
import hibernate.lesson10.entity.ProductQality;
import hibernate.lesson10.util.DAO.OrderDAO;
import hibernate.lesson10.util.DAO.OrderDAOimp;

import java.util.Date;
import java.util.List;

public class OrderServiseImp implements OrderService{

    private OrderDAO dao;
    public OrderServiseImp(){
        dao = new OrderDAOimp();
    }
    @Override
    public Order create(String name,ProductQality qality, Integer amount, Double price, Date creationDate) {
        if(qality!= null& amount!=null&price!=null&creationDate!=null){
            Order order = new Order(name,qality,amount,price,creationDate);
            order.setId(dao.create(order));
            return order;
        }throw new IllegalStateException();

    }

    @Override
    public Order read(Long orderId) {
        if(orderId!=null){
            return dao.read(orderId);
        }
        return null;
    }

    @Override
    public void update(Order order) {
        if(dao.delete(order)){
            System.out.println("Deleted");

        }else {
            System.err.println("Crash");
        }

    }

    @Override
    public void delete(Order order) {
        if (dao.update(order)){
            System.out.println("Update");
        }else System.err.println("Crash");

    }

    @Override
    public List<Order> findAll() {
        return dao.findAll();
    }
}
