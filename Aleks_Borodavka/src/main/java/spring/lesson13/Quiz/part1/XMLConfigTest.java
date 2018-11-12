package spring.lesson13.Quiz.part1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.lesson13.Quiz.part1.entity.Company;

public class XMLConfigTest {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext(
                new String[]{"spring/lesson13/Quiz/spring-config.xml"}
        );

        Company company = context.getBean("company", Company.class);
        System.out.println(company);

    }
}
