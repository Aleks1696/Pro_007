package spring.lesson13.task.annotations.entity;

import org.springframework.beans.factory.annotation.Autowired;

public class Driver extends BaseEmployee {

    @Autowired
    private Car car;

    public Driver(String name, String surname, Double salary) {
        super(name, surname, salary);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("BaseEmployee{");
        sb.append("name='").append(super.getName()).append('\'');
        sb.append(", surname='").append(super.getSurname()).append('\'');
        sb.append(", salary=").append(super.getSalary());
        sb.append(", car=").append(car);
        sb.append('}');
        return sb.toString();
    }
}
