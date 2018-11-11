package spring.homework13.entity;

public class Employee {
    private String name;
    private String surname;
    private Integer salary;

    public Employee(String name, String surname, Integer salary) {
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
