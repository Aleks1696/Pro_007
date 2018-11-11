package spring.lesson13.task.annotations;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.lesson13.task.annotations.config.BeansConfig;
import spring.lesson13.task.annotations.entity.Company;

public class AnnotationsTest {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(BeansConfig.class);
        context.refresh();

        System.out.println(context.getBean(Company.class));
    }
}
