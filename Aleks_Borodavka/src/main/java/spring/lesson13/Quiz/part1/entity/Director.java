package spring.lesson13.Quiz.part1.entity;

public class Director {

    private String name;
    private String Surname;
    private Double salary;
    private Driver driver;

    public Director(String name, String surname, Double salary) {
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
        sb.append(", Surname='").append(Surname).append('\'');
        sb.append(", salary=").append(salary);
        sb.append(", driver=").append(driver);
        sb.append('}');
        return sb.toString();
    }
}
