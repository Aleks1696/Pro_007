package spring.homework13.part1.entity;

public class Driver {
    private String name;
    private String surname;
    private Integer salary;
    private Car car;

    public Driver(String name, String surname, Integer salary) {
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

    public Integer getSalary() {
        return salary;
    }

    public Driver setCar(Car car) {
        this.car = car;
        return this;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Driver{");
        sb.append("name='").append(name).append('\'');
        sb.append(", surname='").append(surname).append('\'');
        sb.append(", salary=").append(salary);
        sb.append(", car=").append(car);
        sb.append('}');
        return sb.toString();
    }
}
