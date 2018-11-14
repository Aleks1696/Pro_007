package spring.lesson13.part1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.lesson13.part1.entity.Human;
import spring.lesson13.part1.entity.Weapon;

public class XMLConfigTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(new String [] {"spring/lesson13/part1/spring-config.xml"});
/* Что бы получить готовую реализацию обьекта Human , нам необходиимо обратиться к контейнеру используя метод
* context.getBean() и указать в параметрах ID необходимого обьекта. Такая методика работы подразумивает передачу управление Spring IoC конейнер.
*
*
* Spring Inversion of Control (Inversion of Control)
*
*
*
* */
        Human ivan = context.getBean("Ivan",Human.class);
        System.out.println(ivan);

        Weapon weapon = context.getBean("Axe",Weapon.class);
        System.out.println(weapon);


    }
}
