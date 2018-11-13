package spring.homework13Part2.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring.homework13Part2.entity.*;


@Configuration
public class BeansConfig {

    @Bean(name = "Ukraine")
    public Company beanCompany(){
        return new Company();
    }

 @Bean(name = "director")
    public Employee beanDirector(){
     return new Director("Igor","Kolomoskii",400.00);
 }
    @Bean(name = "manager")
    public Employee beanManager(){
        return new Manager("Gena","Korban",1.0);
    }

    @Bean(name = "driver")
    public Employee beanDriver(){
        return new Driver( "Petia","Poroshenko",1.0);
    }

    @Bean
    public Car beanCar(){
        return new Car("BMW","black");
    }
}
