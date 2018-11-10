package spring.lesson13.task.xml.entity;

public class Employee {

    private String name;
    private String surname;
    private Double salary;

    public Employee(String name, String surname, Double salary) {
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
    public Double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Employee{");
        sb.append("name='").append(name).append('\'');
        sb.append(", surname='").append(surname).append('\'');
        sb.append(", salary=").append(salary);
        sb.append('}');
        return sb.toString();
    }
}
