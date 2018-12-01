package spring.homework13Part2.entity;

public class BasedEmployee implements Employee {
    private String name;
    private String surname;
    private Double salary;

    public BasedEmployee(String name, String surname, Double salary) {
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



    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("BasedEmployee{");
        sb.append("name='").append(name).append('\'');
        sb.append(", surname='").append(surname).append('\'');
        sb.append(", salary=").append(salary);
        sb.append('}');
        return sb.toString();
    }
}
