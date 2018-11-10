package spring.homework13.part1.entity;

public class Director {
    private String name;
    private String surname;
    private Integer salary;
    private Driver driver;

    public Director(String name, String surname, Integer salary) {
        this.name = name;
        this.surname = surname;
        this.salary = salary;
    }

    public Director setDriver(Driver driver) {
        this.driver = driver;
        return this;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Integer getSalary() {
        return salary;
    }

    public Driver getDriver() {
        return driver;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Director{");
        sb.append("name='").append(name).append('\'');
        sb.append(", surname='").append(surname).append('\'');
        sb.append(", salary=").append(salary);
        sb.append(", driver=").append(driver);
        sb.append('}');
        return sb.toString();
    }
}
