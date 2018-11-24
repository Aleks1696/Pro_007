package spring.lesson14;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.lesson14.entity.Humanoid;
import spring.lesson14.service.HumanoidService;

import java.applet.AppletContext;

public class DataBaseTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/lesson14/config.xml");
        Humanoid humanoid1 = new Humanoid("T100",1499.99);
        Humanoid humanoid2 = new Humanoid("R2D2",1499.99);
        Humanoid humanoid3 = new Humanoid("R2D32",1499.99);

        HumanoidService service = context.getBean(HumanoidService.class);
        service.create(humanoid1);
        service.create(humanoid2);
        service.create(humanoid3);

        service.findAll().forEach(System.out::println);

        Humanoid humanoid = service.get(3L);
        humanoid.setPrice(199.99);
        service.update(humanoid);

        service.findAll().forEach(System.out::println);

        service.delete(humanoid);

        service.findAll().forEach(System.out::println);


    }
}
