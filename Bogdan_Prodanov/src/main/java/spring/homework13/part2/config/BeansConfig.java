package spring.homework13.part2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring.homework13.part2.entity.*;

@Configuration
public class BeansConfig {


    @Bean
    public Company beanCompanySamsung() {
        return new Company();
    }

    @Bean
    public Director beanVasya() {
        return new Director(
                "Vasya",
                "Pupkin",
                123000
        );
    }

    @Bean
    public Driver beanSergey(){
        return new Driver(
                "Sergey",
                "Alehandro",
                21000
        );
    }

    @Bean
    public Car beanCarAudi(){
        return new Car(
                "Audi"
        );
    }

    @Bean
    public Manager beanManagerAndrey() {
        return new Manager(
                "Andrey",
                "Volochenko",
                21421421
        );
    }

}
