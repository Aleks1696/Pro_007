package spring.homework13Part2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.DataAccessResourceFailureException;
import spring.homework13Part2.entity.*;

@Configuration
public class BeansConfig {

    @Bean
    public Company beanCompany(){
        return new Company();
    }

    @Bean
    public Director beanDirector_Igor(){
        return new Director("Igor","Kolomoskii",0);
    }

    @Bean
    public Manager beanManger_Korban(){
        return new Manager("Gena","Korban",0);
    }
    @Bean
    public Driver beanPetr_Driver(){
        return new Driver("Petr","Poroshenko",1);
    }

    @Bean
    public Car beanCar(){
        return new Car("Mazda","Black");
    }


}
