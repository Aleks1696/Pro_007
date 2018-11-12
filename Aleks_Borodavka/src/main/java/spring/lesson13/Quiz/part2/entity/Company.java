package spring.lesson13.Quiz.part2.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Company {

    @Autowired
    @Qualifier("director")
    private Director director;

    @Autowired
    @Qualifier("manager")
    private Manager manager;

    @Autowired
    @Qualifier("driver")
    private Driver driver;

    public void setDirector(Director director) {
        this.director = director;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
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
