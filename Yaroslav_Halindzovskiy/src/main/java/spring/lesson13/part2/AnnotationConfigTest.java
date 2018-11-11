package spring.lesson13.part2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.lesson13.part2.config.BeansCofig;
import spring.lesson13.part2.entity.Hunter;
import spring.lesson13.part2.entity.HunterIntarface;
import spring.lesson13.part2.entity.LeopoldHunter;
import spring.lesson13.part2.entity.Pet;

public class AnnotationConfigTest {
    public static void main(String[] args) {
        /*  AnnotationConfigApplicationContext - позволяет нам настроить начальную
        конфигурацию Spring приложения на этапе его запуска
        *
        *
        *   config.register(BeansCofig.class); - позволяет подключить конфигурационные файлы
        * */

       AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
       context.register(BeansCofig.class);
       context.refresh();

        HunterIntarface hunter1 = context.getBean("Inokentij",HunterIntarface.class);
        HunterIntarface hunter2 = context.getBean("Leopold", LeopoldHunter.class);
        System.out.println(hunter1);
        System.out.println(hunter2);

    }
}
