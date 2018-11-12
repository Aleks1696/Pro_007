package spring.lesson13.Quiz.part2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.lesson13.Quiz.part2.config.BeanConfig;
import spring.lesson13.Quiz.part2.entity.Company;

public class AnnotationConfigTest {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        context.register(BeanConfig.class);
        context.refresh();

        System.out.println(context.getBean(Company.class));
    }
}
