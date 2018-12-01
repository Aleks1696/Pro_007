package spring.homework13.part2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import spring.homework13.part2.config.EmployeeBeansConfig;
import spring.homework13.part2.entity.Company;
import spring.homework13.part2.entity.Director;

public class AnnotionConfigTest {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(EmployeeBeansConfig.class);
        context.refresh();

Company company =context.getBean("Google",Company.class);
        System.out.println(company);
    }
}
