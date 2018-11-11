package spring.lesson13.task.annotations.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring.lesson13.task.annotations.entity.*;

@Configuration
public class BeansConfig {

    @Bean
    public Company beanCompany() {
        return new Company();
    }

    @Bean(name = "director")
    public Employee beanDirector() {
        return new Director("Grigorij", "Stepanov", 4000.00);
    }

    @Bean(name = "manager")
    public Employee beanManager() {
        return new Manager("Viktor", "Leonov", 2500.00);
    }

    @Bean(name = "driver")
    public Employee beanDriver() {
        return new Driver("Leonid", "Petrov", 1000.00);
    }

    @Bean
    public Car beanCar() {
        return new Car("Hundai", "Brown", 2015);
    }
}
