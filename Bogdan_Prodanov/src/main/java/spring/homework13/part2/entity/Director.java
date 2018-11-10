package spring.homework13.part2.entity;

import org.springframework.beans.factory.annotation.Autowired;

public class Director implements Employee{

    private String name;
    private String surname;
    private Integer salary;

    @Autowired
    private Driver driver;

    public Director(String name, String surname, Integer salary) {
        this.name = name;
        this.surname = surname;
        this.salary = salary;
    }

    @Override
    public String getName() {
        return name;
    }


    @Override
    public String getSurname() {
        return surname;
    }

    @Override
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
        sb.append(", salary='").append(salary).append('\'');
        sb.append(", driver=").append(driver);
        sb.append('}');
        return sb.toString();
    }


}
