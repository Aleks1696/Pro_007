package spring.homework13.part2.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Company {
    @Autowired
    @Qualifier("Direktor_Vasya")
    private Director director;
    @Autowired
    @Qualifier("Manager_Evgen")
    private Manager manager;
    @Autowired
    @Qualifier("Driver_Ashot")
    private Driver driver;

    public Company() {
    }

    public Director getDirector() {
        return director;
    }

    public Manager getManager() {
        return manager;
    }

    public Driver getDriver() {
        return driver;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Company{");
        sb.append("director=").append(director);
        sb.append(", manager=").append(manager);
        sb.append(", driver=").append(driver);
        sb.append('}');
        return sb.toString();
    }
}
