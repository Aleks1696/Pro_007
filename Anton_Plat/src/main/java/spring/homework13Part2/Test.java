package spring.homework13Part2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.homework13Part2.entity.Company;
import spring.homework13Part2.config.BeansConfig;

public class Test {
    public static void main(String[] args){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(BeansConfig.class);
        context.refresh();

        System.out.println(context.getBean(Company.class));
    }


}
