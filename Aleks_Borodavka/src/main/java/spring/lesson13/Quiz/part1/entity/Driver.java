package spring.lesson13.Quiz.part1.entity;

public class Driver {

    private String name;
    private String Surname;
    private Double salary;
    private Car car;

    public Driver(String name, String surname, Double salary) {
        this.name = name;
        Surname = surname;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return Surname;
    }

    public Double getSalary() {
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
        sb.append(", Surname='").append(Surname).append('\'');
        sb.append(", salary=").append(salary);
        sb.append(", car=").append(car);
        sb.append('}');
        return sb.toString();
    }
}
