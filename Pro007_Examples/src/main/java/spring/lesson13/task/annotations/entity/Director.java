package spring.lesson13.task.annotations.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Director extends BaseEmployee {

    @Autowired
    @Qualifier("driver")
    private Employee driver;

    public Director(String name, String surname, Double salary) {
        super(name, surname, salary);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("BaseEmployee{");
        sb.append("name='").append(super.getName()).append('\'');
        sb.append(", surname='").append(super.getSurname()).append('\'');
        sb.append(", salary=").append(super.getSalary());
        sb.append(", driver=").append(driver);
        sb.append('}');
        return sb.toString();
    }
}
