package spring.lesson13.part2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.lesson13.part2.config.BeansConfig;
import spring.lesson13.part2.entity.Hunter;

public class AnnotationsConfigTest {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(BeansConfig.class);
        context.refresh();

        Hunter hunter1 = context.getBean(Hunter.class);
        System.out.println(hunter1);
        Hunter hunter2 = context.getBean(Hunter.class);
        System.out.println(hunter2);
    }
}
