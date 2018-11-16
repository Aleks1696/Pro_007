package spring.lesson14;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.lesson14.entity.Humanoid;
import spring.lesson14.service.HumanoidService;

public class DataBaseTest {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "spring/lesson14/config.xml"
        );

        Humanoid humanoid1 = new Humanoid("T1000", 1399.99);
        Humanoid humanoid2 = new Humanoid("R2D2", 1399.99);
        Humanoid humanoid3 = new Humanoid("R2D2ID", 13939.99);

        HumanoidService humanoidService = context.getBean(HumanoidService.class);
        humanoidService.create(humanoid1);
        humanoidService.create(humanoid2);
        humanoidService.create(humanoid3);

        humanoidService.findAll().forEach(System.out::println);

        Humanoid humanoid = humanoidService.get(3L);
        humanoid.setPrice(199.99);
        humanoidService.update(humanoid);
        humanoidService.findAll().forEach(System.out::println);
        humanoidService.delete(humanoid);
        humanoidService.findAll().forEach(System.out::println);
    }
}
