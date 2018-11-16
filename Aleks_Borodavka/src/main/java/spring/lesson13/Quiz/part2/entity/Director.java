package spring.lesson13.Quiz.part2.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Director {

    private String name;
    private String surname;
    private Double salary;

    @Autowired
    @Qualifier("driver")
    private Driver driver;

    public Director(String name, String surname, Double salary) {
        this.name = name;
        this.surname = surname;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Double getSalary() {
        return salary;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
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
