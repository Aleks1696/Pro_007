package spring.lesson13.Quiz.part1.entity;

public class Company {

    private Director director;
    private Manager manager;
    private Driver driver;

    public Company(Director director, Manager manager, Driver driver) {
        this.director = director;
        this.manager = manager;
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
