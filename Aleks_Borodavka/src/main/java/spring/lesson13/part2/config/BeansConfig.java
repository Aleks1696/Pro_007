package spring.lesson13.part2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring.lesson13.part2.entity.Hunter;
import spring.lesson13.part2.entity.HunterInterface;
import spring.lesson13.part2.entity.LeopoldHunter;
import spring.lesson13.part2.entity.Pet;

/*@Configuration - отмечает класс как конфигурационный.
* Класс автоматически будет проинициализирован на этапе запуска приложения*/

@Configuration
public class BeansConfig {

    @Bean(name = "Inokentij")
    public Hunter beanInokentij(){
        return new Hunter(
                "Inokentij",
                100
        );

    }

    @Bean(name = "Leopold")
    public HunterInterface beanTaras(){
        return new LeopoldHunter(
                "Leopold",
                100
        );
    }

    @Bean(name = "Sharik")
    public Pet beanPetSharik(){
        return new Pet(
                "Sharik",
                100,
                12
        );
    }

    @Bean(name = "Tuzik")
    public Pet beanPetTuzik(){
        return new Pet(
                "Tuzik",
                100,
                15
        );
    }

}
