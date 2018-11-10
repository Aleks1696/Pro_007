package spring.lesson13.task.xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.lesson13.task.xml.entity.Company;

public class XMLResult {

    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext(new String[]{"spring/lesson13/task/config.xml"});
        System.out.println(context.getBean(Company.class));
    }
}
