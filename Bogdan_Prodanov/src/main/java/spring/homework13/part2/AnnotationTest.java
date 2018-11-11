package spring.homework13.part2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.homework13.part2.config.BeansConfig;
import spring.homework13.part2.entity.Company;
import spring.homework13.part2.entity.Employee;

public class AnnotationTest {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext();

        context.register(BeansConfig.class);
        context.refresh();



        Company employee = context.getBean(Company.class);
        System.out.println(employee);

    }
}
