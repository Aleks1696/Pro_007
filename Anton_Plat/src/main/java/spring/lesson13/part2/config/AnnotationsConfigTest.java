//package spring.lesson13.part2.config;
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//import spring.lesson13.part2.entity.Hunter;
//import spring.lesson13.part2.entity.Hunterinterface;
//
//public class AnnotationsConfigTest {
//    public static void main(String[] args) {
//        /*
//        AnnotationConfigApplicationContext   Позволяет нам настроить начальную конфигурацию Спринг на
//        этапе запуска
//         */
//        AnnotationConfigApplicationContext context =
//                new AnnotationConfigApplicationContext();
//        /*
//        config.register(<Configuration.class>); - позволяет подключить конфигурациионные данные файлы
//        config.refresh(); - позволяет обновить конфигурацию приложения
//
//         */
//
//        context.register(BeansConfig.class);
//        context.refresh();
//
//        Hunter hunter = context.getBean("Inokentij",Hunter.class);
//        System.out.println(hunter);
//        Hunterinterface hunter1 = context.getBean("Leopold",Hunterinterface.class);
//        System.out.println(hunter1);
//
//
//    }
//}
