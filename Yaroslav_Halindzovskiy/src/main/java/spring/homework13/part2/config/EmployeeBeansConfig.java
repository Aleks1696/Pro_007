package spring.homework13.part2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring.homework13.part2.entity.*;

@Configuration
public class EmployeeBeansConfig {

    @Bean(name = "Direktor_Vasya")
    public Director beanDirektorVasya (){
        return new Director("Vasya","Onegin",1000);

    }

    @Bean (name = "Manager_Evgen")
    public Manager beanManagerEngen (){
        return new Manager("Evgen", "Linked",1000);
    }
    @Bean (name = "Driver_Ashot")
    public Driver beanDriverAshot(){
        return new Driver("Ashot", "Kuraga",300);
    }

    @Bean(name = "Toyota")
        public Car beenCarToyota () {
            return new Car  ("Toyota");
        }
@Bean(name = "Google")
    public Company beanCompany () {
        return new Company();
}

}
