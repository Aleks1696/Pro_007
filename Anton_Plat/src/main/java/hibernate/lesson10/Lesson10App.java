package hibernate.lesson10;

import hibernate.lesson10.entity.Order;
import hibernate.lesson10.entity.types.ProductQuality;
import hibernate.lesson10.util.HibernateUtil;
import hibernate.service.OrderService;
import hibernate.service.OrderServiceImpl;

import java.util.Calendar;

public class Lesson10App {
    public static void main(String[] args) {
        OrderService service = new OrderServiceImpl();

        Order milk = service.create("Milk",ProductQuality.TOXIC,
                5,
                100.00,
                Calendar.getInstance().getTime());

        Order meat = service.create("MEAT",ProductQuality.PRIMARY,
                50,
                125.00,
                Calendar.getInstance().getTime());

        service.findAll().forEach(System.out:: println);
        meat.setQuality(ProductQuality.SECONADRY);
        service.update(meat);
        service.findAll().forEach(System.out::println);

        service.findAll().forEach(System.out::println);

        HibernateUtil.getFactory().close();
    }
}
