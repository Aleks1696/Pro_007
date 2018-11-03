package hibernate.lesson10;

import hibernate.lesson10.entity.Order;
import hibernate.lesson10.entity.ProductQality;
import hibernate.lesson10.service.OrderServiseImp;
import hibernate.lesson10.util.HibernateUtil;

import java.util.Calendar;

public class Lesson10App {
    public static void main(String[] args) {

        OrderServiseImp servise = new OrderServiseImp();
        servise.create("MILK",ProductQality.TOXIC,5,100.00, Calendar.getInstance().getTime());
        servise.create("MEAT",ProductQality.TOXIC,5,100.20,Calendar.getInstance().getTime());
        Order meat =  servise.create("BEER",ProductQality.PRIMARY,10,120.20,Calendar.getInstance().getTime());
        servise.findAll().forEach(System.out::println);
        servise.update(meat);
        servise.findAll().forEach(System.out::println);
       HibernateUtil.getFactory().close();
    }


}
