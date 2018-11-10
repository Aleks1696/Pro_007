package spring.homework13.part2.entity;

import spring.homework13.part2.Employee.Employee;

public class Manager  implements Employee {
    private String name;
    private String surname;
    private Integer salary;

    public Manager(String name, String surname, Integer salary) {
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
        final StringBuilder sb = new StringBuilder("Manager{");
        sb.append("name='").append(name).append('\'');
        sb.append(", surname='").append(surname).append('\'');
        sb.append(", salary=").append(salary);
        sb.append('}');
        return sb.toString();
    }
}
