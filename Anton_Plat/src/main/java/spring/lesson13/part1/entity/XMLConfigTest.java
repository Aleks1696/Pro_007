package spring.lesson13.part1.entity;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class XMLConfigTest {
    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext(new String[]{"spring/lesson13/part1/spring-config.xml"});
        /* Чтобы получить готовую реализацию объекта Human,нам необходимо обратится к контейнеру используя метод context.getBean()
        и указать в параметрах ID необходимо объекта.Такая методика работы подразумевает передачу управления Spring IoC контейнеру

        Spring IoC (Inversion of Control)

         */
        Human ivan = context.getBean("Ivan",Human.class);
        System.out.println(ivan);
        System.out.println(ivan.getWeapon());

        Weapon weapon = context.getBean("Axe",Weapon.class);
        System.out.println(weapon);


    }
}
