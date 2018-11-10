package spring.lesson13.part1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.lesson13.part1.entity.Human;
import spring.lesson13.part1.entity.Weapon;

public class XMLConfigTest {

    public static void main(String[] args) {
        /* Context - хранит внутри все реализации объектов которы мы
           подготавливаем. */
        ApplicationContext context =
                new ClassPathXmlApplicationContext(
                        new String[] {"spring/lesson13/part1/spring-config.xml"});
        /* Чтобы получить готовую реализацию объекта Human, нам необходимо
        *  обратится к контейнеру используя метод context.getBean() и указать
        *  в параметрах ID необходимого объекта. Такая методика работы
        *  подразумевает передачу управления  Spring IoC контейнеру.
        *
        *  Spring IoC (Inversion of Control)*/
        Human ivan = context.getBean("Ivan", Human.class);
        System.out.println(ivan);
        System.out.println(ivan.getWeapon());

        Weapon weapon = context.getBean("Axe", Weapon.class);
        System.out.println(weapon);
    }
}
