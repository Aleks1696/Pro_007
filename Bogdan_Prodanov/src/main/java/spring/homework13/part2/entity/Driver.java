package spring.homework13.part2.entity;

import org.springframework.beans.factory.annotation.Autowired;

public class Driver implements Employee{
    private String name;
    private String surname;
    private Integer salary;
    @Autowired
    private Car car;

    public Driver(String name, String surname, Integer salary) {
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





    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Driver{");
        sb.append("name='").append(name).append('\'');
        sb.append(", surname='").append(surname).append('\'');
        sb.append(", salary='").append(salary).append('\'');
        sb.append(", car=").append(car);
        sb.append('}');
        return sb.toString();
    }


}
