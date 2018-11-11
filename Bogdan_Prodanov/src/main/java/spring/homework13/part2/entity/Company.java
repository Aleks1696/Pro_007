package spring.homework13.part2.entity;

import org.springframework.beans.factory.annotation.Autowired;

public class Company {
    @Autowired
    private Director director;
    @Autowired
    private Manager manager;
    @Autowired
    private Driver driver;

    public Company() {}

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
