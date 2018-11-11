package spring.lesson14;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DataBaseTest {
    public static void main(String[] args) {
        ApplicationContext  context = new ClassPathXmlApplicationContext("spring/lesson14/config.xml");
    }
}
