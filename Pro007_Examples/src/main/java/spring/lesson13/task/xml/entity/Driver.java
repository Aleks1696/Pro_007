package spring.lesson13.task.xml.entity;

public class Driver extends Employee {

    private Car car;

    public Driver(String name, String surname, Double salary) {
        super(name, surname, salary);
    }

    public Car getCar() {
        return car;
    }
    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Director{");
        sb.append("name='").append(super.getName()).append('\'');
        sb.append(", surname='").append(super.getSurname()).append('\'');
        sb.append(", salary=").append(super.getSalary());
        sb.append(", car=").append(car);
        sb.append('}');
        return sb.toString();
    }
}
