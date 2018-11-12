package spring.lesson13.Quiz.part2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring.lesson13.Quiz.part2.entity.*;

@Configuration
public class BeanConfig {

    @Bean(name = "company")
    public Company beenCompany(){
        return new Company();
    }

    @Bean(name = "director")
    public Director beenDirector(){
        return new Director(
                "Herr",
                "Director",
                3600.80
        );
    }

    @Bean(name = "manager")
    public Manager beenManager(){
        return new Manager(
                "John",
                "Muller",
                8999.00
        );
    }

    @Bean(name = "driver")
    public Driver beenDriver(){
        return new Driver(
                "Ivan",
                "Ivanovich",
                5888.98
        );
    }

    @Bean(name = "car")
    public Car beenCar(){
        return new Car(
                "Mercedes",
                560000
        );
    }

}
