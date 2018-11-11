package spring.homework13Part2.config;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.homework13Part2.entity.Company;
import spring.lesson13.part2.config.BeansConfig;

public class AnnotationsConfigTest {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(BeansConfig.class);
        context.refresh();

        Company company = context.getBean(Company.class);
        System.out.println(company);
    }
}
