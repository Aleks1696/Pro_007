package hibernate.lesson10;

import hibernate.lesson10.entity.Order;
import hibernate.lesson10.entity.types.ProductQuality;
import hibernate.lesson10.service.OrderService;
import hibernate.lesson10.service.OrderServiceImpl;
import hibernate.lesson10.util.HibernateUtil;

import java.util.Calendar;

public class Lesson10App {

    public static void main(String[] args) {
        OrderService service = new OrderServiceImpl();
        Order milk = service.create(
                "MILK",
                ProductQuality.TOXIC,
                5,
                100.00,
                Calendar.getInstance().getTime());

        Order meat = service.create(
                "MEAT",
                ProductQuality.PRIMARY,
                50,
                125.00,
                Calendar.getInstance().getTime());

        service.findAll().forEach(System.out::println);
        meat.setQuality(ProductQuality.SECONDARY);
        service.update(meat);

        service.findAll().forEach(System.out::println);

        service.delete(milk);

        service.findAll().forEach(System.out::println);

        HibernateUtil.getFactory().close();
    }
}
