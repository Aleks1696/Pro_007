package spring.homework13.entity;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.homework13.entity.Company;

public class XMLTest {
    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext(new String[]{"spring/homework13/spring-config.xml"} );
        System.out.println(context.getBean(Company.class));
    }
}
