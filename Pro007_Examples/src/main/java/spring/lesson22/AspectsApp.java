package spring.lesson22;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.lesson22.dao.CarDAO;
import spring.lesson22.entity.Car;

public class AspectsApp {

    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext(
                        "spring/lesson22/config.xml"
                );
        CarDAO carDAO = context.getBean(CarDAO.class);

        Car car = new Car("Kia", "Black", 2010);

        Long id = carDAO.create(car);

        Car result = carDAO.read(id);

        result.setColor("WHITE");

        carDAO.update(result);
    }
}
