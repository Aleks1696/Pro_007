package spring.homework13Part2.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.persistence.criteria.CriteriaBuilder;

public class Director implements Employeeinterface {
    private String name;
    private String surname;
    private Integer salary;

    @Autowired
    private Driver driver;


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

    public Director(String name, String surname, Integer salary) {
        this.name = name;
        this.surname = surname;
        this.salary = salary;
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
