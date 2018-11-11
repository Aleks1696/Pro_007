package spring.homework13Part2.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Company {
    @Autowired
    private Director director;

    @Autowired
    private Manager manager;

    @Autowired
    private Driver driver;

    public Company() {
        this.director = director;
        this.manager = manager;
        this.driver = driver;
    }

    public Director getDirector() {
        return director;
    }

    public Company setDirector(Director director) {
        this.director = director;
        return this;
    }

    public Manager getManager() {
        return manager;
    }

    public Company setManager(Manager manager) {
        this.manager = manager;
        return this;
    }

    public Driver getDriver() {
        return driver;
    }

    public Company setDriver(Driver driver) {
        this.driver = driver;
        return this;
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
