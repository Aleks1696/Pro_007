package spring.lesson13.part2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring.lesson13.part2.entity.Hunter;
import spring.lesson13.part2.entity.Pet;

@Configuration
public class BeansConfig {

    @Bean
    public Hunter beanInokentij(){
        return new Hunter("Inokentij",100);
    }

    @Bean(name = "Taras")
    public Hunter beanTaras() {
        return new Hunter("Taras",100);
    }

    @Bean
    public Pet beanPet() {
        return new Pet("Vasya",100,12);
    }

}
