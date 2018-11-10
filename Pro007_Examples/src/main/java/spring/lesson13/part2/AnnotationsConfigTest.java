package spring.lesson13.part2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.lesson13.part2.config.BeansConfig;
import spring.lesson13.part2.entity.Hunter;
import spring.lesson13.part2.entity.HunterInterface;

public class AnnotationsConfigTest {

    public static void main(String[] args) {
        /* AnnotationConfigApplicationContext позволяет нам настроить
        * начальную конфигурацию Spring приложения на этапе его запуска*/
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext();
        /* context.register(<Configuration.class>); - позволяет подключить
        *  конфигурационные файлы
        *  context.refresh(); - позволяет обновить конфигурацию
        *  приложения*/
        context.register(BeansConfig.class);
        context.refresh();

        HunterInterface hunter1 = context.getBean("Inokentij", HunterInterface.class);
        System.out.println(hunter1);
        HunterInterface hunter2 = context.getBean("Leopold", HunterInterface.class);
        System.out.println(hunter2);
    }
}
