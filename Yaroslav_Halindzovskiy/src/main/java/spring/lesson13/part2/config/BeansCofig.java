package spring.lesson13.part2.config;


import org.springframework.context.annotation.*;
import spring.lesson13.part2.entity.Hunter;
import spring.lesson13.part2.entity.Pet;

/*@Configuraion - класс автоматически будет проинициализирован на этапе запуска приложения */

@Configuration
public class BeansCofig {

    @Bean("Inokentij")
    public Hunter beanInokentij() {
        return new Hunter("Inokentij", 100);
    }

    ;

    @Bean(name = "Taras")
    public Hunter beanTaras() {
        return new Hunter("Taras", 100);
    }

    @Bean (name = "Sharik")
    public Pet beanPet() {

        return new Pet("Sharik", 100, 12);
    }

    @Bean(name = "Tuzik")
    public Pet beanPetTuzik (){
        return new Pet ("Tukiz", 100,15);
    }
}
