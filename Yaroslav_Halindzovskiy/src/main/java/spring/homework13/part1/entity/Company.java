package spring.homework13.part1.entity;

public class Company {
    private Director director;
    private Manager manager;
    private Driver driver;


    public Company setDirector(Director director) {
        this.director = director;
        return this;
    }

    public Company setManager(Manager manager) {
        this.manager = manager;
        return this;
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
