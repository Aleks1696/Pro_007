package spring.lesson13.task.xml.entity;

public class Director extends Employee {

    public Driver driver;

    public Director(String name, String surname, Double salary) {
        super(name, surname, salary);
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
        sb.append("name='").append(super.getName()).append('\'');
        sb.append(", surname='").append(super.getSurname()).append('\'');
        sb.append(", salary=").append(super.getSalary());
        sb.append(", driver=").append(driver);
        sb.append('}');
        return sb.toString();
    }
}
