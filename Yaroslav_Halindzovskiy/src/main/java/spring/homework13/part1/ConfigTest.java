package spring.homework13.part1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.homework13.part1.entity.*;

public class ConfigTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"spring/homework13/spring-config.xml"});
        Driver driver = context.getBean("driver",Driver.class);
        Car car = context.getBean("car",Car.class);
        Manager manager = context.getBean("manager",Manager.class);
        Company company = context.getBean("company",Company.class);
        Director director = context.getBean("director",Director.class);
        System.out.println(driver);
        System.out.println(car);
        System.out.println(manager);
        System.out.println(company);
        System.out.println(director);

    }
}
