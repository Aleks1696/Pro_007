package spring.lesson14;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.homework14.entity.CPU;
import spring.homework14.entity.Laptop;
import spring.lesson14.entity.Humanoid;
import spring.lesson14.service.HumanoidService;

import java.util.Date;

public class DataBaseTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/lesson14/config.xml");

        Humanoid humanoid1 = new Humanoid("T1000", 149.99);
        Humanoid humanoid2 = new Humanoid("R2D2", 149.99);
        Humanoid humanoid3 = new Humanoid("DROID", 14.00);



        HumanoidService service = context.getBean(HumanoidService.class);
        service.create(humanoid1);
        service.create(humanoid2);
        service.create(humanoid3);

        service.findAll().forEach(System.out::println);

         humanoid3 = service.get(3L);
        humanoid2.setPrice(199.99);
        service.update(humanoid3);

        service.findAll().forEach(System.out::println);
        service.delete(humanoid3);
        service.findAll().forEach(System.out::println);

    }
}